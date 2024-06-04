plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    kotlin("plugin.serialization") version "2.0.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false

}