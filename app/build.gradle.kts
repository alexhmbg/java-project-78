plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("info.picocli:picocli:4.6.1")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")

    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.8.1")
    testImplementation ("org.assertj:assertj-core:3.21.0")
    testImplementation ("org.skyscreamer:jsonassert:1.5.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports { xml.required.set(true) }
}