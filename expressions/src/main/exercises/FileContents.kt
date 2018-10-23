import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 * This class takes a CSV list of filenames, adds .txt if missing, then reads all the contents out of the file, or creates it
 * and returns "<empty file>" if it doesn't exist.
 *
 * Convert this file to Kotlin, then alter the code to use the Kotlin "let" expression instead of assignment
 *
 * Can you reduce the entire function to a single expression with no return statement?
</empty> */
class FileContents {
    @Throws(IOException::class)
    fun contentsOf(csvFileNames: String): List<String> = csvFileNames.split(",").map {
        File(resolveFileName(it)).let {
            it.name + ":" + tryToRead(it).substring(0, 10)
        }
    }

    private fun tryToRead(file: File): String =
            if (!file.exists()) {
                try {
                    file.createNewFile()
                    "<empty file>"
                } catch (e: IOException) {
                    "<could not create>"
                }
            } else {
                FileReader(file).use { file.readLines().joinToString(",") }
            }

    private fun resolveFileName(fileName: String) = if (fileName.endsWith(".txt")) fileName else fileName + ".txt"
}
