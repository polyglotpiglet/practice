package bonus

import question.Progression


class FibonacciProgression(override val endInclusive: Fib, override val start: Fib) : Progression<Fib> {
    override fun iterator() = object :Iterator<Fib> {
        override fun hasNext(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun next(): Fib {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

data class Fib(val index: Int): Comparable<Fib> {
    override fun compareTo(other: Fib): Int = index.compareTo(other.index)

    operator fun rangeTo(other: Fib): Fib = this
}

fun main(args: Array<String>) {
    println(Fib(0) < Fib(2))

    (Fib(0)..Fib(5))
}