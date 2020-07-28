OpenApi DSL
===========

[![Build Status](https://travis-ci.org/acme-software/openapi-dsl.svg?branch=master)](https://travis-ci.org/acme-software/openapi-dsl)

**A multi platform DSL / library to build and maintain [open-api](https://www.openapis.org/) (a.k.a. 
[Swagger](https://swagger.io/)) specifications in [Kotlin](#kotlin-dsl), [Java](#java-dsl), [Scala](#scala-dsl) and 
[JS](#javascript-dsl)**

***Heads up:** This library is still "work in progress" and by no means production-ready. Feel free to issue pull 
requests ;)*

Usage
-----

The project is splitted into language specific, idiomatic high level DSLs and a common low level DSL. As the name 
suggests, the high level DSLs are by far more convenient and as boilerplate-free as possible. Only use the low level DSL 
if absolutely needed of if there is no high level DSL for the desired target language.

Kotlin DSL
----------

Kotlin uses an idiomatic, typesafe builder DSL to get stuff done. A little example:

```kotlin
import ch.acmesoftware.openapidsl.kotlin.v3.*

val api: OpenApi = openApi {
    info("Example API Doc", "1.0.0") {
        description = "Lorem Ipsum Dolor si amet..."
        termsOfService = "https://www.example.tld/tos"
    }
    servers(
        server("http://localhost:8080"),
        server("httpa://api.domain.tld") {
            description = "Lorem Ipsum"
        }
    )
    tags(
        tag("Foo"),
        tag("Bar") {
            description = "Some tag description..."
        }
    )
}

```

Java DSL
--------

TBD...

Scala DSL
---------

Idiomatic Scala support still needs some time...

Until then, you can basically just use the Java DSL, because it's pure ;)

JavaScript DSL
--------------

JS support is still experimental (and therefore also undocumented).

Low Level DSL
-------------

The term "low level DSL" means the simplest underlying AST (object structure) which basically represents the OpenApi 
specification. It is possible, but in rare conditions useful, to construct the object-tree by hand. However, these 
structures are used to generate and parse OpenApi JSON or YML definitions. All high level DSLs are building upon this.

Minimal Example using the low level DSL:

```kotlin
// kotlin
import ch.acmesoftware.openapidsl.lowlevel.v3.*

val res: String = OpenApi(
    info = Info(
        title = "Minimal Example",
        version = "1.0.0"
    )
).toJson()
```

Serializers
-----------

The OpenApi spec can be serrialized to JSON using one of the following serializers:

### Jackson

Requires `openapi-dsl-jackson`

```kotlin
import ch.acmesoftware.openapidsl.kotlin.v3.*
import ch.acmesoftware.openapidsl.jackson.OpenApiExtensions.toJson

openApi {
    info("Minial Example", "1.0.0")
}.toJson()
```

Misc
----

Neither this project nor its owner ACME Software Solutions GmbH is related with [Swagger](https://swagger.io/), 
[SmartBear Software](https://smartbear.com/) or the [Open API Initiative](https://www.openapis.org/) in any legal or 
personal way.

This project is published unter the MIT License. See [LICENSE file](LICENSE.txt)