class Welcomer private constructor(private val message: String?) {

    init {
        println("Welcome to Real World $message")
    }

    private fun printEachCharacter(): String = when {
        message != null -> {
            printCharacters(message)
            "Go $message!"
        }
        else -> "No message"
    }

    private fun printCharacters(message: String) {
        message.toUpperCase().toCharArray().forEach {
            println("Give me a $it!")
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val finalMessage = Welcomer("Kotlin").printEachCharacter()
            println(finalMessage)
        }
    }
}
