plugins {
    java
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
}

dependencies {
    implementation("org.springframework.kafka:spring-kafka:3.0.5")
    implementation("io.confluent:kafka-avro-serializer:7.3.3") {
        exclude(group = "org.slf4j", module = "slf4j-log4j12")
        exclude(group = "log4j", module = "log4j")
        exclude(group = "io.swagger", module = "swagger-annotations")
        exclude(group = "io.swagger", module = "swagger-core")
    }
    implementation("org.apache.avro:avro:1.11.1")


}