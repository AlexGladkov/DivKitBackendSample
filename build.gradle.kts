plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.5"
    application
}

group = "tech.mobiledeveloper"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("MainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.5")
    implementation("io.ktor:ktor-server-netty:2.3.5")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.5")
    implementation("io.ktor:ktor-server-cors:2.3.5")
    implementation("io.ktor:ktor-serialization-jackson:2.3.5") // Убедись, что версия соответствует используемой версии Ktor
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("com.yandex.div:kotlin-json-builder:30.15.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}