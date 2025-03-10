plugins {
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
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")

    implementation(project(":infrastructure:kafka-model"))
    implementation(project(":infrastructure:kafka-consumer"))
    implementation(project(":infrastructure:kafka-producer"))
}

