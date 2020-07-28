package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#path-item-object]
 */
@Serializable
data class PathItem(
    @SerialName("\$ref")
    val ref: String? = null,
    val summary: String? = null,
    val description: String? = null,
    val get: Operation? = null,
    val put: Operation? = null,
    val post: Operation? = null,
    val delete: Operation? = null,
    val options: Operation? = null,
    val head: Operation? = null,
    val patch: Operation? = null,
    val trace: Operation? = null,
    val servers: List<Server> = emptyList(),
    val parameters: List<ParameterOrReference> = emptyList()
) {
    /**
     * @see [https://swagger.io/specification/#operation-object]
     */
    @Serializable
    data class Operation(
        val tags: List<String> = emptyList(),
        val summary: String? = null,
        val description: String? = null,
        val externalDocs: ExternalDocumentation? = null,
        val operationId: String? = null,
        val parameters: List<ParameterOrReference> = emptyList(),
        val requestBody: RequestBodyOrReference? = null,
        val responses: Map<String, Response> = emptyMap(),
        val callbacks: Map<String, CallbackOrReference> = emptyMap(),
        val deprecated: Boolean = false,
        val security: List<SecurityRequirement> = emptyList(),
        val servers: List<Server> = emptyList()
    )
}