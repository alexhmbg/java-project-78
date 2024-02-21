plugins {
    java
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("info.picocli:picocli:4.7.3")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.1")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")

    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation ("org.assertj:assertj-core:3.24.2")
    testImplementation ("org.skyscreamer:jsonassert:1.5.1")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports { xml.required.set(true) }
}