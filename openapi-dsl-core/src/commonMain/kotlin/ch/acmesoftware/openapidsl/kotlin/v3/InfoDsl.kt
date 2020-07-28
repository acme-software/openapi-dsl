package ch.acmesoftware.openapidsl.kotlin.v3

import ch.acmesoftware.openapidsl.lowlevel.v3.Info

class InfoDsl(
    val title: String,
    val version: String
) {

    var description: String? = null

    var termsOfService: String? = null

    var contact: Info.Contact? = null

    var license: Info.License? = null


    fun build(): Info = Info(
        title = title,
        description = description,
        termsOfService = termsOfService,
        contact = contact,
        license = license,
        version = version
    )
}