package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestBodyOrReference(
    @SerialName("\$ref")
    val ref: String? = null

//TODO
)