package bonus

import question.Progression


class FibonacciProgression( override val start: Fib, override val endInclusive: Fib) : Progression<Fib> {
    override fun iterator() = object :Iterator<Fib> {
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): Fib = current.apply { current = Fib(current.index + 1) }
    }
}

data class Fib(val index: Int): Comparable<Fib> {

    val value: Int = when(index) {
        0, 1 -> 1
        else -> Fib(index - 1).value + Fib(index - 2).value
    }

    override fun compareTo(other: Fib): Int = index.compareTo(other.index)

    operator fun rangeTo(other: Fib): FibonacciProgression = FibonacciProgression(this, other)
}

fun main(args: Array<String>) {
    println(Fib(0) < Fib(2))

    val result = (Fib(0)..Fib(5)).map { it.value }.joinToString()

    println(result)
}