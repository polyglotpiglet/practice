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

    fun netAmount(first: Money, vararg rest: Money): Money {

        var total = first

        for (next in rest) {
            if (next.currency != total.currency) {
                throw Incalculable()
            }
        }

        for (next in rest) {
            total = Money(total.amount + next.amount, next.currency)
        }

        val amount = total.amount * (percent / 100.0)
        val tax = Money(amount.toInt(), first.currency)

        return if (total.currency == tax.currency) {
            Money(total.amount - tax.amount, first.currency)
        } else {
            throw Incalculable()
        }
    }

    internal class Money(val amount: Int, val currency: String)
}
