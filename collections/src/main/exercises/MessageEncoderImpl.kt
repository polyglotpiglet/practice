class MessageEncoderImpl : MessageEncoder {
    override fun encode(messages: MutableList<String>): MutableList<String> = messages
            .filter { it.length > 10 }
            .map { encode(it) }
            .toMutableList()

    private fun encode(str: String): String = str
            .map { it.toLowerCase() }
            .filter { !setOf('a', 'e', 'i', 'o', 'u', ' ').contains(it) }
            .groupBy { it }
            .map { e -> "${e.key}${e.value.size}" }
            .sorted()
            .joinToString(separator = " ") { it }
}