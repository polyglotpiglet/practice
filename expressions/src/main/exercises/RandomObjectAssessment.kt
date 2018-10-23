import java.time.LocalDateTime
import java.util.Arrays

import java.lang.Integer.parseInt

/**
 * Convert this file to Kotlin, then alter the code to use the Kotlin "when" expression.
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
class RandomObjectAssessment {
    fun judge(o: Any): String = when (o) {
        1, 2 -> "o is one or two"
        is Double -> "o is a double, so the tan of it is " + Math.tan(o)
        is LocalDateTime -> "o is a datetime. yesterday was " + o.toLocalDate().toString()
        in (4..11).map { it.toString() } -> "o is between 4 and 11"
        in 17..19 -> "o is either 17, 18, or 19"
        else -> {
            println(parseInt(o.toString()) in 4..11)
            "o is none of the above"
        }
    }

}