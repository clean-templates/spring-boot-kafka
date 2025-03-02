package com.rolandsall.kafka.template.producer.excecption;

public class FailedToProduceMessageToKafkaException extends RuntimeException {

    public FailedToProduceMessageToKafkaException(String message) {
        super(message);
    }
}
