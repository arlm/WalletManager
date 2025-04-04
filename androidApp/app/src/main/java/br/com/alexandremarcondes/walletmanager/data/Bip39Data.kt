package br.com.alexandremarcondes.walletmanager.data

import br.com.alexandremarcondes.walletmanager.bitcoin.bip39.Bip39

data class Bip39Data(
    val wordlist: Array<String> = emptyArray(),
    val seedBits: CharArray = CharArray(0),
    val seed: Array<Byte> = emptyArray()
) {
    constructor(bip39: Bip39) : this(
        wordlist = bip39.wordlist,
        seed = bip39.seed,
        seedBits = bip39.seedBits
    )

    val isValid: Boolean = wordlist.isNotEmpty() && seedBits.isNotEmpty()  && seed.isNotEmpty()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bip39Data

        if (!wordlist.contentEquals(other.wordlist)) return false
        if (!seedBits.contentEquals(other.seedBits)) return false
        if (!seed.contentEquals(other.seed)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = wordlist.contentHashCode()
        result = 31 * result + seedBits.contentHashCode()
        result = 31 * result + seed.contentHashCode()
        return result
    }
}
