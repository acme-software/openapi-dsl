package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#response-object]
 */
@Serializable
data class Response(
    val description: String
    //TODO
)