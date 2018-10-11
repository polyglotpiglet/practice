fun toCamelCase(value: String) = value.split(" ").map { capitalizeFirst(it) }.joinToString("")

fun capitalizeFirst(value: String): String = value.take(1).capitalize() + value.drop(1).toLowerCase()

