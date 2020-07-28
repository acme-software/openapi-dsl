package ch.acmesoftware.openapidsl.lowlevel.v3

import com.fasterxml.jackson.databind.ObjectMapper
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.test.Test
import kotlin.test.fail

class OpenApiTest {

    @UnstableDefault
    private val json = Json(
        JsonConfiguration(
            prettyPrint = true,
            indent = "  "
        )
    )

    private val om = ObjectMapper()

    private val schema = JsonSchemaFactory
        .getInstance(SpecVersion.VersionFlag.V4)
        .getSchema(javaClass.getResourceAsStream("/schema/v3_0.json"))

    @Test
    fun `minimal example must be valid json`() {

        val res = OpenApi(
            info = Info(
                title = "Minimal Example",
                version = "1.0.0"
            )
        )

        val jsonStr = json.stringify(OpenApi.serializer(), res)

        val errors = schema.validate(om.readTree(jsonStr))

        if (errors.isNotEmpty()) {
            fail(jsonStr + "\n\n" + errors.joinToString("\n") { it.message })
        }
    }

    @Test
    fun `servers must be valid json`() {

        val res = OpenApi(
            info = Info(
                title = "Minimal Example",
                version = "1.0.0"
            ),
            servers = listOf(
                Server(url = "http://localhost:8080"),
                Server(url = "http://www.acmesoftware.ch/api")
            )
        )

        val jsonStr = json.stringify(OpenApi.serializer(), res)

        val errors = schema.validate(om.readTree(jsonStr))

        if (errors.isNotEmpty()) {
            fail(jsonStr + "\n\n" + errors.joinToString("\n") { it.message })
        }
    }

    @Test
    fun `paths must be valid json`() {

        val res = OpenApi(
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

        val jsonStr = json.stringify(OpenApi.serializer(), res)

        val errors = schema.validate(om.readTree(jsonStr))

        if (errors.isNotEmpty()) {
            fail(jsonStr + "\n\n" + errors.joinToString("\n") { it.message })
        }
    }
}