package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#tag-object]
 */
@Serializable
data class Tag(
    val name: String,
    val description: String? = null,
    val externalDocs: ExternalDocumentation?
)