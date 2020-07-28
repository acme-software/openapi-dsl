package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * Root class of the open-api specification
 *
 * @see [https://swagger.io/specification/#openapi-object]
 */
@Serializable
data class OpenApi(
    val openapi: String = "3.0.3",
    val info: Info,
    val servers: List<Server> = emptyList(),
    val paths: Map<String, PathItem> = emptyMap(),
    val components: Components? = null,
    val security: List<SecurityRequirement> = emptyList(),
    val tags: List<Tag> = emptyList(),
    val externalDocs: ExternalDocumentation? = null
)