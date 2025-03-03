plugins {
    id("myproject.spring-conventions")
    id("myproject.testing-conventions")
}

group = "com.rolandsall"
version = "unspecified"


dependencies {
    // internal projects
    implementation(project(":order-service:order-domain:order-core"))
    implementation(project(":order-service:order-application"))
    implementation(project(":common"))


    // frameworks and 3rd parties
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

