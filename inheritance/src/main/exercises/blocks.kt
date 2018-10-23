data class CryptoCurrency(private var mbtc: Int) {
    operator fun plus(that: CryptoCurrency): CryptoCurrency = CryptoCurrency(mbtc + that.mbtc)
}

fun main(args : Array<String>) {

    val init = CryptoCurrency(1)
    println(init + init)


}