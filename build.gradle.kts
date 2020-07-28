import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("multiplatform") version "1.3.72"
    kotlin("plugin.serialization") version "1.3.72"
}

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.multiplatform")
        plugin("org.jetbrains.kotlin.plugin.serialization")
    }

    repositories {
        mavenCentral()
    }
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}