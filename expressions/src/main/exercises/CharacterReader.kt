import java.io.File
import java.io.FileReader
import java.io.Reader
import java.util.ArrayList
import java.util.HashSet

/**
 * This class calculates the sorted list of all characters in a particular input file.
 *
 * Convert this file to Kotlin, fix the errors as directed by IntelliJ, then alter the code to use the Kotlin "use" and "try" expressions instead of assignment. The Kotlin extensions to the Java File API will help you here!!
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.io.-file/
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
class CharacterReader {


    fun readCharactersFrom(fileName: String): List<Char> = try {
        FileReader(File(fileName)).use {
            val characters = HashSet<Char>()

            while (true) {
                val read = it.read()
                if (read == -1) break
                characters.add(read.toChar())
            }
            characters.toList().sorted()

        }
    } catch (e: Exception) {
        ArrayList()
    }

}
