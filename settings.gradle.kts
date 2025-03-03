rootProject.name = "kafka-template"
include("order-service")
include("infrastructure")
include("infrastructure:kafka-producer")
include("infrastructure:kafka-consumer")
include("infrastructure:kafka-model")
include("infrastructure:kafka-config-data")

// order service
include("order-service:order-domain")
include("order-service:order-domain:order-core")
include("order-service:order-domain:order-application-service")
include("order-service:order-starter")
include("order-service:order-application")
include("common")
