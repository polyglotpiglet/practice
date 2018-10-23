import org.junit.Assert.assertEquals
import org.junit.Test

class UsingInvokeTests {

    @Test
    fun `converts to camel case`() {
        assertEquals(hello("John Doe"), "Hello, John Doe!")
    }

    @Test
    fun `converts to camel case using invoke`(){
        assertEquals(::hello.invoke("John Doe"), "Hello, John Doe!")
    }
}