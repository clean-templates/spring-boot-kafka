plugins {
    id("myproject.spring-conventions")
    id("myproject.testing-conventions")
}

group = "com.rolandsall"
version = "unspecified"


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":order-service:order-domain:order-core"))

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

