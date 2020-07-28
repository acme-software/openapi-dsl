package ch.acmesoftware.openapidsl.jackson

import ch.acmesoftware.openapidsl.jackson.OpenApiExtensions.toJson
import ch.acmesoftware.openapidsl.lowlevel.v3.Info
import ch.acmesoftware.openapidsl.lowlevel.v3.OpenApi
import ch.acmesoftware.openapidsl.lowlevel.v3.PathItem
import ch.acmesoftware.openapidsl.lowlevel.v3.Server
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import kotlin.test.Test
import kotlin.test.fail

class JacksonSerializerTest {

    private val om = jacksonObjectMapper()

    private val schema = JsonSchemaFactory
        .getInstance(SpecVersion.VersionFlag.V4)
        .getSchema(javaClass.getResourceAsStream("/schema/v3_0.json"))

    @Test
    fun `minimal example must be valid json`() {
        validateJsonSchema(
            OpenApi(
                info = Info(
                    title = "Minimal Example",
                    version = "1.0.0"
                )
            )
        )
    }

    @Test
    fun `servers must be valid json`() {
        validateJsonSchema(
            OpenApi(
                info = Info(
                    title = "Minimal Example",
                    version = "1.0.0"
                ),
                servers = listOf(
                    Server(url = "http://localhost:8080"),
                    Server(
                        url = "http://www.acmesoftware.ch/api",
                        description = "Some other server"
                    ),
                    Server(
                        url = "https://api.some.tld",
                        variables = mapOf(
                            "foo" to Server.Variable(
                                default = "true"
                            ),
                            "bar" to Server.Variable(
                                description = "A variable",
                                default = "1234"
                            ),
                            "baz" to Server.Variable(
                                enum = listOf(
                                    "a", "b", "c"
                                ),
                                default = "a"
                            )
                        )
                    )
                )
            )
        )
    }

    @Test
    fun `paths must be valid json`() {
        validateJsonSchema(
            OpenApi(
                info = Info(
                    title = "Minimal Example",
                    version = "1.0.0"
                ),
                paths = mapOf(
                    "/foo" to PathItem(
                        summary = "Foo Resource",
                        description = "Lorem ipsum dolor, si amet. Ipsum est."
                    )
                )
            )
        )
    }

    private fun validateJsonSchema(definition: OpenApi) {

        val jsonStr = definition.toJson()

        val errors = schema.validate(om.readTree(jsonStr))

        if (errors.isNotEmpty()) {
            fail(jsonStr + "\n\n" + errors.joinToString("\n") { it.message })
        }
    }
}