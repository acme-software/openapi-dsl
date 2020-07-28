package ch.acmesoftware.openapidsl.kotlin.v3

import ch.acmesoftware.openapidsl.lowlevel.v3.OpenApi
import kotlin.test.Test
import kotlin.test.assertEquals

class OpenApiDslTest {

    @Test
    fun `should build info object correctly`() {

        val res: OpenApi = openApi {
            info("Example API Doc", "1.0.0") {
                description = "Lorem Ipsum Dolor si amet..."
                termsOfService = "https://www.example.tld/tos"
            }
            servers(
                server("http://localhost:8080"),
                server("httpa://api.domain.tld") {
                    description = "Lorem Ipsum"
                }
            )
            tags(
                tag("Foo"),
                tag("Bar") {
                    description = "Some tag description..."
                }
            )
        }

        assertEquals("Example API Doc", res.info.title)
        assertEquals("1.0.0", res.info.version)
        assertEquals("Lorem Ipsum Dolor si amet...", res.info.description)
        assertEquals("https://www.example.tld/tos", res.info.termsOfService)

        assertEquals(2, res.servers.size)
        assertEquals("http://localhost:8080", res.servers[0].url)
        assertEquals("httpa://api.domain.tld", res.servers[1].url)
        assertEquals("Lorem Ipsum", res.servers[1].description)

        assertEquals("Foo", res.tags[0].name)
        assertEquals("Bar", res.tags[1].name)
        assertEquals("Some tag description...", res.tags[1].description)
    }
}