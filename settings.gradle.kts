rootProject.name = "kafka-template"
include("order-service")
include("infrastructure")
include("infrastructure:kafka-producer")
include("infrastructure:kafka-consumer")
include("infrastructure:kafka-model")
include("infrastructure:kafka-config-data")
