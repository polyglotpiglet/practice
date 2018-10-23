import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionTests {

    @Test
    fun `converts to camel case`() {
        assertEquals(("my first extension").toCamelCase(), "MyFirsNtExtension")
    }

}