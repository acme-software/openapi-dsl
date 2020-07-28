package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlin.test.Test
import kotlin.test.assertNotNull

class OpenApiTest {

    @Test
    fun `must be buildable with minimal defaults`() {

        val res = OpenApi(
            info = Info(
                title = "Minimal Example",
                version = "1.0.0"
            )
        )

        assertNotNull(res)
    }
}