sealed class Try<out R> {

    fun orThrow(): R = when(this) {
        is Success -> this.value
        is Failure -> throw RuntimeException()
    }



    companion object {
        operator fun <X> invoke(fn: () -> X): Try<X> = try {
            Success(fn())
        }
        catch (e: Exception) {
            Failure(e)
        }
    }

}

data class Success<out R>(val value: R): Try<R> ()

data class Failure(val exception: Exception) : Try<Nothing>()

fun main(args: Array<String>) {

    val success: Try<Int> = Success(1)
    val failure: Try<Int> = Failure(RuntimeException())



}