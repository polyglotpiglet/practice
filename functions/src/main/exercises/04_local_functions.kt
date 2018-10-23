
fun printWordLengths(value: String): String {
    
    fun countEach(words: List<String>) = words.map { it to it.length }

    fun printOnePerLine(wordLengths: List<Pair<String, Int>>) = wordLengths.map { "${it.first} (${it.second})" }

    val words = value.split(" ")
    val wordLengths = countEach(words)
    val formatted = printOnePerLine(wordLengths)
    return formatted.joinToString("\n")
}
