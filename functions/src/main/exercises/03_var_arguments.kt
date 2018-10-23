fun externalPrintNumbers(numbers: List<Number>): String = numbers.joinToString(" -> ")

fun printNumbers(vararg value: Number): String {
    return externalPrintNumbers(value.asList())
}

fun printListOfNumbers(numbers: List<Number>): String {
    return printNumbers(*numbers.toTypedArray())
}