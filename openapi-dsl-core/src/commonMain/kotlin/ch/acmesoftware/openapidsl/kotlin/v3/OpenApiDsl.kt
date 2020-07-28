package ch.acmesoftware.openapidsl.kotlin.v3

import ch.acmesoftware.openapidsl.lowlevel.v3.OpenApi
import ch.acmesoftware.openapidsl.lowlevel.v3.Server
import ch.acmesoftware.openapidsl.lowlevel.v3.Tag

class OpenApiDsl(private val openapi: String? = null) {

    private lateinit var info: InfoDsl

    private var servers: List<Server> = emptyList()
    private var tags: List<Tag> = emptyList()

    fun info(
        title: String,
        version: String
    ) = info(title, version) {}

    fun info(
        title: String,
        version: String,
        init: InfoDsl.() -> Unit
    ) {
        val info = InfoDsl(title, version)
        init(info)
        this.info = info
    }

    fun servers(vararg servers: Server) {
        this.servers = servers.toList()
    }

    fun tags(vararg tags: Tag) {
        this.tags = tags.toList()
    }

    fun build(): OpenApi = OpenApi(
        openapi = openapi ?: OpenApi.defaultVersion,
        info = info.build(),
        servers = servers,
        //TODO: paths, components, security

        tags = tags
    )
}

fun openApi(init: OpenApiDsl.() -> Unit): OpenApi {
    val api = OpenApiDsl()

    init(api)

    return api.build()
}