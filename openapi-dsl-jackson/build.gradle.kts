kotlin {

    val jacksonVersion = "2.11.0"

    jvm()

    sourceSets {

        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(project(":openapi-dsl-core"))

                implementation(kotlin("stdlib-jdk8"))
                implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
                implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
            }
        }

        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation("com.networknt:json-schema-validator:1.0.42")
            }
        }
    }
}