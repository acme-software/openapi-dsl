package ch.acmesoftware.openapidsl.kotlin.v3

import ch.acmesoftware.openapidsl.lowlevel.v3.ExternalDocumentation
import ch.acmesoftware.openapidsl.lowlevel.v3.Tag

class TagDsl(val name: String) {

    var description: String? = null

    var externalDocs: ExternalDocumentation? = null

    internal fun build(): Tag = Tag(
        name = name,
        description = description,
        externalDocs = externalDocs
    )
}

fun tag(name: String): Tag =
    tag(name) {}

fun tag(name: String, init: TagDsl.() -> Unit): Tag {
    val tag = TagDsl(name)

    init(tag)

    return tag.build()
}