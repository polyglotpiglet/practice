data class CryptoCurrency(private var mbtc: Int) {
    operator fun plus(that: CryptoCurrency): CryptoCurrency = CryptoCurrency(mbtc + that.mbtc)
}

class CryptoBank {
    private val accounts = mutableMapOf<String, CryptoCurrency>()

    operator fun set(account: Int, balance: CryptoCurrency): Unit {
        accounts.put(account.toString(), balance)
    }

    operator fun get(account: Int): CryptoCurrency? = accounts[account.toString()]
}

class WalletRange(override val start: CryptoWallet,
                  override val endInclusive: CryptoWallet) : ClosedRange<CryptoWallet>, Iterable<CryptoWallet> {
    override fun iterator() = object: Iterator<CryptoWallet> {
        var current = start
        override fun hasNext() = current.seed <= endInclusive.seed
        override fun next() = current.apply { current = CryptoWallet(current.seed.inc()) }
    }
}


data class CryptoWallet(val seed: Char) : Comparable<CryptoWallet> {
    override fun compareTo(other: CryptoWallet): Int = seed.compareTo(other.seed)
    operator fun rangeTo(other: CryptoWallet) =  WalletRange(this, other)
}


fun main(args: Array<String>) {

    val init = CryptoCurrency(1)

    // mathematical operations
    println(init + init)

    // set operations
    val bank = CryptoBank()
    bank[123] = init

    println(bank[456])
    println(bank[123])

    // ranges
    println(CryptoWallet('a') < CryptoWallet('z'))

    (CryptoWallet('a')..CryptoWallet('z')).forEach(::println)


}