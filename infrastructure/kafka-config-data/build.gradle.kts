plugins {
    java
    id("myproject.kafka-avro-conventions")
    id("myproject.spring-conventions")

}

group = "com.rolandsall"
version = "unspecified"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
}