import org.junit.Assert.assertEquals
import org.junit.Test

class NamedArgumentsTests {

    @Test
    fun `basic`() {
        assertEquals(sayHello("World",
            false,
            false,
            false), "Hello, World")
    }

    @Test
    fun `exclamation`() {
        assertEquals(sayHello("World",
            true,
            false,
            false), "Hello, World!")
    }

    @Test
    fun `question`() {
        assertEquals(sayHello("World",
            false,
            true,
            false), "Hello, World?")
    }

    @Test
    fun `capitalise`() {
        assertEquals(sayHello("World",
            false,
            false,
            true), "Hello, WORLD")
    }
}