package br.com.alexandremarcondes.walletmanager.bitcoin

import br.com.alexandremarcondes.walletmanager.Util.base58CheckEncode
import br.com.alexandremarcondes.walletmanager.data.Bip39Data
import org.bouncycastle.asn1.x9.X9ECParameters
import org.bouncycastle.crypto.ec.CustomNamedCurves
import org.bouncycastle.crypto.params.ECDomainParameters
import org.bouncycastle.math.ec.FixedPointCombMultiplier
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class Bip32(bip39: Bip39Data) {
    val mainnetPrivateKey: String
    val mainnetPublicKey: String
    val testnetPrivateKey: String
    val testnetPublicKey: String
    val rootKeyBytes: ByteArray

    init {
        rootKeyBytes = deriveBIP32RootKey(bip39.seed)
        mainnetPrivateKey = rootKeyToString(rootKeyBytes, isPrivate = true, isTestnet = false)
        mainnetPublicKey = rootKeyToString(rootKeyBytes, isPrivate = false, isTestnet = false)
        testnetPrivateKey = rootKeyToString(rootKeyBytes, isPrivate = true, isTestnet = true)
        testnetPublicKey = rootKeyToString(rootKeyBytes, isPrivate = false, isTestnet = true)
    }

    /**
     * Derives a BIP32 root key from a 256-bit seed according to the BIP32 specification.
     *
     * @param seed A 256-bit seed as a ByteArray
     * @return The BIP32 root key as a ByteArray
     */
    private fun deriveBIP32RootKey(seed: ByteArray): ByteArray {
        // Verify that the seed is 256 bits (32 bytes)
        require(seed.size == 32) { "Seed must be 256 bits (32 bytes), it has ${seed.size}" }

        // BIP32 uses "Bitcoin seed" as the key for HMAC-SHA512
        val key = "Bitcoin seed".toByteArray(StandardCharsets.UTF_8)

        // Create HMAC-SHA512 instance
        val mac = Mac.getInstance("HmacSHA512")
        val secretKeySpec = SecretKeySpec(key, "HmacSHA512")
        mac.init(secretKeySpec)

        // Compute HMAC-SHA512 of the seed
        val hmacResult = mac.doFinal(seed)

        // HMAC-SHA512 produces a 512-bit (64-byte) result
        // The first 256 bits (32 bytes) become the master private key
        // The last 256 bits (32 bytes) become the master chain code
        // Together they form the root key

        // Return the entire 64-byte result as the root key
        return hmacResult
    }

    /**
     * Derives a public key from a private key using secp256k1 elliptic curve
     *
     * @param privateKey The 32-byte private key
     * @return The 33-byte compressed public key (or 65-byte uncompressed)
     */
    private fun derivePublicKey(privateKey: ByteArray, compressed: Boolean = true): ByteArray {
        // Get curve parameters for secp256k1
        val params: X9ECParameters = CustomNamedCurves.getByName("secp256k1")
        val curve = ECDomainParameters(
            params.curve,
            params.g,
            params.n,
            params.h
        )

        // Convert privateKey to BigInteger
        val privKey = BigInteger(1, privateKey)

        // Perform the elliptic curve multiplication
        val q: org.bouncycastle.math.ec.ECPoint? = FixedPointCombMultiplier().multiply(curve.g, privKey)

        // Get the encoded point (public key)
        return if (compressed) {
            q!!.getEncoded(true) // 33 bytes compressed format
        } else {
            q!!.getEncoded(false) // 65 bytes uncompressed format
        }
    }

    /**
     * Utility function to separate the private key and chain code from the root key.
     * This is often needed when working with the root key.
     */
    private fun extractKeyAndChainCode(rootKey: ByteArray): Pair<ByteArray, ByteArray> {
        require(rootKey.size == 64) { "Root key must be 512 bits (64 bytes)" }

        val masterPrivateKey = rootKey.copyOfRange(0, 32)
        val masterChainCode = rootKey.copyOfRange(32, 64)

        return Pair(masterPrivateKey, masterChainCode)
    }

    /**
     * Calculate the fingerprint of a public key (first 4 bytes of RIPEMD160(SHA256(pubKey)))
     */
    fun calculateFingerprint(pubKey: ByteArray): ByteArray {
        val sha256 = MessageDigest.getInstance("SHA-256")
        val ripemd160 = MessageDigest.getInstance("RIPEMD160")

        val sha256Hash = sha256.digest(pubKey)
        val ripemd160Hash = ripemd160.digest(sha256Hash)

        return ripemd160Hash.copyOfRange(0, 4)
    }

    /**
     * Converts a BIP32 root key to its standard string representation (Base58Check encoding).
     *
     * @param rootKey The 64-byte root key composed of the master private key (32 bytes) and chain code (32 bytes)
     * @param isPrivate Whether to encode as a private key (true) or public key (false)
     * @param isTestnet Whether to use testnet version bytes (true) or mainnet (false)
     * @return The Base58Check encoded string representation of the BIP32 key
     */
    private fun rootKeyToString(rootKey: ByteArray, isPrivate: Boolean = true, isTestnet: Boolean = false): String {
        require(rootKey.size == 64) { "Root key must be 512 bits (64 bytes)" }

        // Extract the key parts
        val (masterKey, chainCode) = extractKeyAndChainCode(rootKey)

        // Determine version bytes (4 bytes)
        val version = when {
            isPrivate && !isTestnet -> byteArrayOf(0x04, 0x88.toByte(), 0xAD.toByte(), 0xE4.toByte())   // xprv (mainnet private)
            isPrivate && isTestnet -> byteArrayOf(0x04, 0x35, 0x83.toByte(), 0x94.toByte())             // tprv (testnet private)
            !isPrivate && !isTestnet -> byteArrayOf(0x04, 0x88.toByte(), 0xB2.toByte(), 0x1E)           // xpub (mainnet public)
            else -> byteArrayOf(0x04, 0x35, 0x87.toByte(), 0xCF.toByte())                               // tpub (testnet public)
        }

        // Create the extended key structure
        val extKey = ByteBuffer.allocate(78).apply {
            put(version)                    // Version (4 bytes)
            put(0)                       // Depth (1 byte)
            putInt(0)                 // Parent fingerprint (4 bytes)
            putInt(0)                 // Child number (4 bytes)
            put(chainCode)                  // Chain code (32 bytes)
            if (isPrivate) {
                put(0)                   // Private key marker (1 byte)
                put(masterKey)              // Key data (32 bytes)
            } else {
                // Derive public key from private key
                val pubKey = derivePublicKey(masterKey, true) // Get compressed public key (33 bytes)
                put(pubKey)           // Key data (33 bytes for compressed public key)
            }
        }.array()

        // Perform Base58Check encoding
        return extKey.base58CheckEncode()
    }
}
