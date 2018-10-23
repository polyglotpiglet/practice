import org.junit.Assert.assertEquals
import org.junit.Test

class NamedArgumentsTests {

    @Test
    fun `basic`() {
        assertEquals(sayHelloToYou("World"), "Hello, World")
    }

    @Test
    fun `exclamation`() {
        assertEquals(sayHelloToYou("World", addExclamation = true), "Hello, World!")
    }

    @Test
    fun `question`() {
        assertEquals(sayHelloToYou("World", addQuestionMark = true), "Hello, World?")
    }

    @Test
    fun `capitalise`() {
        assertEquals(sayHelloToYou("World", capitalise = true), "Hello, WORLD")
    }

    @Test
    fun `question and exclamation`() {
        assertEquals(sayHelloToYou("World", addQuestionMark = true, addExclamation = true), "Hello, World!?")
    }
}