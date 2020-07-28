package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#external-documentation-object]
 */
@Serializable
data class ExternalDocumentation(
    val description: String? = null,
    val url: String
)