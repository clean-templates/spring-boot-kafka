plugins {
    id("java")
    id("myproject.spring-conventions")
    id("myproject.testing-conventions")
    id("myproject.lombok-conventions")
    id("myproject.kafka-avro-conventions")
}

group = "com.rolandsall"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":order-service:order-domain:order-core"))
    implementation(project(":order-service:order-domain:order-application-service"))

    // kafka-module
    implementation(project(":infrastructure:kafka-model"))
    implementation(project(":infrastructure:kafka-consumer"))
    implementation(project(":infrastructure:kafka-producer"))
}

tasks.test {
    useJUnitPlatform()
}