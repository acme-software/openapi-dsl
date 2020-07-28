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
                implementation(kotlin("test-junit5"))
                implementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
                implementation("com.networknt:json-schema-validator:1.0.42")
            }
        }
    }
}