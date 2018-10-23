package question

import java.util.Arrays

/**
 * - Fix the IntelliJ warnings with the file
 * - Introduce an operator function plus() on Money
 * - Introduce an operator function minus() on Money
 * - Encapsulate the percent value in a data class, and implement an operator function times() on Money which receives it
 * - Replace the for loop with a functional construct which sums the monies
 */
internal class TakeHomeCalculator(private val percent: Int) {

//    fun netAmount(first: Money, vararg rest: Money): Money {
//
//        val total = rest.fold(first) { acc, next -> acc + next }
//        val totalWithDeduction = total - Percentage(percent)
//        return totalWithDeduction
//
//    }
//
//    internal data class Money(val amount: Int, val currency: String) {
//        operator fun plus(that: Money): Money = if (currency == that.currency) {
//            copy(amount = amount + that.amount)
//        } else throw Incalculable()
//
//        operator fun minus(that: Money): Money = if (currency == that.currency) {
//            copy(amount = amount - that.amount)
//        } else throw Incalculable()
//
//        operator fun minus(percentage: Percentage): Money = copy(amount = amount - (amount * percentage.value / 100.0).toInt())
//    }
//
//    internal data class Percentage(val value: Int)


    fun netAmount(first: Money, vararg rest: Money): Money {

        val total = rest.fold(first) { acc, next -> acc + next }
        val tax = total * percent
        return total - tax

    }

    internal data class Money(val amount: Int, val currency: String) {
        operator fun plus(that: Money): Money = if (currency == that.currency) {
            copy(amount = amount + that.amount)
        } else throw Incalculable()

        operator fun minus(that: Money): Money = if (currency == that.currency) {
            copy(amount = amount - that.amount)
        } else throw Incalculable()

        // why make percentage a data class??? p55 q6
        operator fun times(percentage: Int): Money = copy(amount = (amount * percentage / 100.0).toInt())
    }
}


