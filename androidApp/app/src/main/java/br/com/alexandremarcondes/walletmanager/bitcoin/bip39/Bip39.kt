package br.com.alexandremarcondes.walletmanager.bitcoin.bip39

import br.com.alexandremarcondes.walletmanager.wordlists.englishWordlist
import br.com.alexandremarcondes.walletmanager.wordlists.portugueseWordlist
import br.com.alexandremarcondes.walletmanager.wordlists.spanishWordlist
import java.security.MessageDigest
import java.util.Locale
import kotlin.experimental.and
import kotlin.experimental.or

class Bip39(val wordlist: Array<String>, dictionary: Array<String>) {
    val seed: Array<Byte>
    val seedBits: CharArray

    init {
        if (!validate(wordlist, dictionary)) throw Error("Invalid wordlist")

        val bitLength = wordlist.size * 11
        val checksumLength = bitLength / 33
        val entropyLength = bitLength - checksumLength

        val (entropy, bitArray) = extractEntropy(entropyLength, bitLength, wordlist, dictionary)
        this.seed = entropy.toTypedArray()
        this.seedBits = bitArray
    }

    companion object {
        fun validate(wordlist: Array<String>, dictionary: Array<String>): Boolean {
            if (wordlist.isEmpty()) return false
            if (wordlist.size < 12 || wordlist.size > 24) return false
            if (wordlist.size % 3 != 0) return false

            val bitLength = wordlist.size * 11
            val checksumLength = bitLength / 33
            val entropyLength = bitLength - checksumLength

            try {
                val (entropy, bitArray) = extractEntropy(entropyLength, bitLength, wordlist, dictionary)

                val md = MessageDigest.getInstance("SHA-256")
                val hash = md.digest(entropy.toByteArray())
                val hashBitArray = CharArray(hash.size * 8)

                for ((index, byte) in hash.withIndex()) {
                    for (bitIndex in 0..<8) {
                        hashBitArray[index * 8 + bitIndex] =
                            if ((byte and ((1 shl (7 - bitIndex)).toByte())) != 0.toByte()) '1' else '0'
                    }
                }

                for (index in 0..<checksumLength) {
                    if (bitArray[entropyLength + index] != hashBitArray[index])
                        return false
                }

            } catch (e: Error) {
                return false
            }

            return true
        }

        fun detectLanguage(wordlist: Array<String>): String {
            if (wordlist.all { word -> englishWordlist.contains(word.lowercase(Locale.getDefault())) }) return "English"
            if (wordlist.all { word -> portugueseWordlist.contains(word.lowercase(Locale.getDefault())) }) return "Português"
            if (wordlist.all { word -> spanishWordlist.contains(word.lowercase(Locale.getDefault())) }) return "Español"

            throw Error("Language not detected")
        }

        private fun extractEntropy(
            entropyLength: Int,
            bitLength: Int,
            wordlist: Array<String>,
            dictionary: Array<String>
        ): Pair<MutableList<Byte>, CharArray> {
            val entropy = MutableList<Byte>(entropyLength / 8) { 0 }
            val bitArray = CharArray(bitLength)

            for ((wordIndex, word) in wordlist.withIndex()) {
                val index = dictionary.indexOf(word)
                if (index < 0) throw Error("word not found: $word")

                for (bitIndex in 0..<11) {
                    bitArray[(wordIndex * 11) + bitIndex] =
                        if ((index and (1 shl (10 - bitIndex))) != 0) '1' else '0'
                }
            }

            for (byteIndex in 0..<entropy.size) {
                for (bitIndex in 0..<8) {
                    if (bitArray[(byteIndex * 8) + bitIndex] == '1') {
                        entropy[byteIndex] = entropy[byteIndex] or (1 shl (7 - bitIndex)).toByte()
                    }
                }
            }

            return Pair(entropy, bitArray)
        }
    }
}