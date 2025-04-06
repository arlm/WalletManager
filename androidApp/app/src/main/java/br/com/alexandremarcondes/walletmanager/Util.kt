package br.com.alexandremarcondes.walletmanager

import java.math.BigInteger
import java.security.MessageDigest

object Util {

    /**
     * Extension function to convert ByteArray to hex string for debugging
     */
    fun ByteArray.toHexString(): String {
        return joinToString("") { byte -> "%02x".format(byte) }
    }

    private fun ByteArray.base58Encode(): String {
        // Base58 alphabet
        val alphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"

        // Count leading zeros
        var zeroCount = 0
        while (zeroCount < this.size && this[zeroCount] == 0.toByte()) {
            zeroCount++
        }

        // Convert bytes to BigInteger
        val num = BigInteger(1, this)

        // Encode to Base58
        val base = BigInteger.valueOf(58)
        val sb = StringBuilder()
        var numCopy = num

        while (numCopy > BigInteger.ZERO) {
            val div = numCopy.divideAndRemainder(base)
            numCopy = div[0]
            val remainder = div[1].toInt()
            sb.append(alphabet[remainder])
        }

        // Add leading '1's for each leading zero byte
        for (i in 0 until zeroCount) {
            sb.append("1")
        }

        // Reverse the string
        return sb.reverse().toString()
    }

    /**
     * Calculate the double SHA-256 checksum (first 4 bytes)
     */
    private fun ByteArray.calculateChecksum(): ByteArray {
        val digest = MessageDigest.getInstance("SHA-256")
        val firstHash = digest.digest(this)
        val secondHash = digest.digest(firstHash)
        return secondHash.copyOfRange(0, 4)
    }

    /**
     * Base58Check encoding implementation
     */
    fun ByteArray.base58CheckEncode(): String {
        // Combine data and checksum (first 4 bytes of double SHA-256)
        val dataWithChecksum = this + this.calculateChecksum()

        // Convert to Base58
        return dataWithChecksum.base58Encode()
    }

}