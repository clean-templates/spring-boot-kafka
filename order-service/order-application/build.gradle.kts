plugins {
    id("myproject.spring-conventions")
    id("myproject.testing-conventions")
    id("myproject.common-conventions")
    id("myproject.lombok-conventions")
}

group = "com.rolandsall"
version = "unspecified"


dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":order-service:order-domain:order-application-service"))
    implementation(project(":common"))

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

