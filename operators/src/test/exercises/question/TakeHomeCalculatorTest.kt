package question

import org.junit.Test

import org.junit.Assert.assertEquals

class TakeHomeCalculatorTest {

    @Test
    fun canCalculateTax() {
        val first = TakeHomeCalculator(10).netAmount(TakeHomeCalculator.Money(40, "GBP"), TakeHomeCalculator.Money(50, "GBP"), TakeHomeCalculator.Money(60, "GBP")).amount
        assertEquals(135, first.toLong())
    }

    @Test(expected = Incalculable::class)
    fun cannotSumDifferentCurrencies() {
        TakeHomeCalculator(10).netAmount(TakeHomeCalculator.Money(4, "GBP"), TakeHomeCalculator.Money(5, "USD"))
    }
}
