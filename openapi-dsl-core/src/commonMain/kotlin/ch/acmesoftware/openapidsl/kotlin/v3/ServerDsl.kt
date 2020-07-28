package ch.acmesoftware.openapidsl.kotlin.v3

import ch.acmesoftware.openapidsl.lowlevel.v3.Server

class ServerDsl(val url: String) {

    var description: String? = null

    var variables: Map<String, Server.Variable> = emptyMap()

    internal fun build(): Server = Server(
        url = url,
        description = description,
        variables = variables
    )
}

fun server(url: String): Server =
    server(url) {}

fun server(url: String, init: ServerDsl.() -> Unit): Server {
    val server = ServerDsl(url)

    init(server)

    return server.build()
}