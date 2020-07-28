package ch.acmesoftware.openapidsl.lowlevel.v3

import kotlinx.serialization.Serializable

/**
 * @see [https://swagger.io/specification/#info-object]
 */
@Serializable
data class Info(
    val title: String,
    val description: String? = null,
    val termsOfService: String? = null,
    val contact: Contact? = null,
    val license: License? = null,
    val version: String
) {
    /**
     * @see [https://swagger.io/specification/#contact-object]
     */
    @Serializable
    data class Contact(
        val name: String? = null,
        val url: String? = null,
        val email: String? = null
    )

    /**
     * @see [https://swagger.io/specification/#license-object]
     */
    @Serializable
    data class License(
        val name: String,
        val url: String? = null
    )
}