plugins {
    id("java")
    id("myproject.spring-conventions")
    id("myproject.testing-conventions")
    id("myproject.lombok-conventions")
}

group = "com.rolandsall"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":common"))
    implementation(project(":order-service:order-domain:order-core"))
}

tasks.test {
    useJUnitPlatform()
}