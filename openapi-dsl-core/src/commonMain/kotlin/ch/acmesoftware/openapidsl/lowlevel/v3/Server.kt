package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#server-object]
 */
@Serializable
data class Server(
    val url: String,
    val description: String? = null,
    val variables: Map<String, Variable> = emptyMap()
) {
    /**
     * @see [https://swagger.io/specification/#server-variable-object]
     */
    @Serializable
    data class Variable(
        val enum: List<String> = emptyList(),
        val default: String,
        val description: String? = null
    )
}