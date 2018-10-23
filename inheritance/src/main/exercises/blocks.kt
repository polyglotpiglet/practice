import java.lang.Integer.parseInt

fun countLetters(sentence: String): Int = sentence.filter { it.isLetter() } .count()

fun allTheLetters() {
    println(countLetters("the quick brown fox jumps over the lazy dog"))
    println(countLetters("strong and stable, weak and wobbly"))
}

fun describeYear(year: Int): String {
    val description = if (year > 1957) {
        "Space"
    } else if (year > 1970) {
        "Multimedia"
    } else if (year > 1987) {
        "Multimedia"
    } else if (year > 2001) {
        "Big data"
    } else {
        "Prehistoric"
    }

    return "The $description Age"
}


fun main(args : Array<String>) {

    println(describeYear(2001))


}