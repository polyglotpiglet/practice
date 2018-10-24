package bonus

import question.Progression

data class Fibonacci(val prev2: Int, val prev1: Int) : Comparable<Fibonacci> {
    val value by lazy { prev2 + prev1 }
    override fun compareTo(other: Fibonacci): Int = value.compareTo(other.value)
    operator fun rangeTo(other: Fibonacci) =  FibonacciRange(this, other)
}

class FibonacciRange(override val start: Fibonacci, override val endInclusive: Fibonacci) : Progression<Fibonacci> {
    override fun iterator() = object : Iterator<Fibonacci> {
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): Fibonacci = current.apply { current = Fibonacci(current.prev1, current.value) }
    }

}

fun main(args: Array<String>) {
    val start = Fibonacci(0, 1)
    val end = Fibonacci(100, 101)
    (start..end).take(5).map { it.value }.forEach(::println)
}


