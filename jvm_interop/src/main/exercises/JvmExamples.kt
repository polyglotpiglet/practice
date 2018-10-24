import java.util.*

class JvmNames {

    @JvmName("copyStringList")
    fun copyList(s: List<String>): List<String> = s

    fun copyList(i: List<Int>): List<Int> = i
}

inline fun maths(noinline generate: () -> Int, transform: (Int) -> Int) = transform(generate())

fun main(args: Array<String>) {

    // this will get compiled differently because of the inline
    val result = maths(Random()::nextInt) {it * 2 }
}