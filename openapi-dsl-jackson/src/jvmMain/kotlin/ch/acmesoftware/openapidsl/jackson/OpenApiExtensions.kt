package ch.acmesoftware.openapidsl.jackson

import ch.acmesoftware.openapidsl.lowlevel.v3.OpenApi
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object OpenApiExtensions {

    private val objectMapper = jacksonObjectMapper()

    init {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    }

    /**
     * Serialize using default object mapper
     */
    fun OpenApi.toJson(): String = toJson(objectMapper)

    /**
     * Serialize using custom objectMapper
     *
     * Caution: This could lead to invalid / not schema compliant OpenApi json
     */
    fun OpenApi.toJson(om: ObjectMapper): String =
        om.writeValueAsString(this)
}