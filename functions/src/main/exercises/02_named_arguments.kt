fun sayHelloToYou(name: String, addExclamation: Boolean = false, addQuestionMark: Boolean = false, capitalise: Boolean= false): String {
    val toPrint = name
        .let { if (addExclamation) it + "!" else it }
        .let { if (addQuestionMark) it + "?" else it }
        .let { if (capitalise) it.toUpperCase() else it }

    return "Hello, $toPrint"
}
