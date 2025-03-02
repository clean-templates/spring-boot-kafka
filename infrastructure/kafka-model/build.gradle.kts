import com.github.davidmc24.gradle.plugin.avro.GenerateAvroJavaTask

plugins {
    java
    id("myproject.kafka-avro-conventions")
    id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"


}

group = "com.rolandsall"
version = "unspecified"

val generateAvro = tasks.register("generateAvro", GenerateAvroJavaTask::class) {
    group = "Generation"
    description = "Generates Avro Java files from Avro schemas."
    source("src/main/resources/avro")
    setOutputDir(file("src/main/java"))
}
