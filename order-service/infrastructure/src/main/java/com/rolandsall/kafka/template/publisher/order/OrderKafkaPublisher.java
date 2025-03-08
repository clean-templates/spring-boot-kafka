package com.rolandsall.kafka.template.publisher.order;

import com.rolandsall.kafka.template.config.OrderTopicConfiguration;
import com.rolandsall.kafka.template.event.OrderCreatedEvent;
import com.rolandsall.kafka.template.order.avro.model.OrderAvroModel;
import com.rolandsall.kafka.template.ports.output.message.order.OrderMessagePublisher;
import com.rolandsall.kafka.template.producer.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderKafkaPublisher implements OrderMessagePublisher {

    private final OrderMessageMapper mapper;
    private final OrderTopicConfiguration orderTopicConfiguration;
    private final KafkaProducer<String, OrderAvroModel> kafkaProducer;

    @Override
    public void publish(OrderCreatedEvent orderCreatedEvent) {
        try {
            log.info("Publishing order created event to kafka with id {}", orderCreatedEvent.getOrder().getId());
            OrderAvroModel orderCreatedEventAvro = mapper.mapToAvroModel(orderCreatedEvent);
            kafkaProducer.send(orderTopicConfiguration.getOrderTopic(), orderCreatedEvent.getOrder().getId(), orderCreatedEventAvro, handleResultCallback(orderCreatedEvent));
            log.info("Order created event published to kafka with id {}", orderCreatedEvent.getOrder().getId());
        } catch (Exception e) {
            log.error("Failed to publish order created event to kafka with id {}", orderCreatedEvent.getOrder().getId(), e);
        }

    }

    private static BiConsumer<SendResult<String, OrderAvroModel>, Throwable> handleResultCallback(OrderCreatedEvent orderCreatedEvent) {
        return (sendResult, throwable) -> {
            if (throwable != null) {
                log.error("Failed to publish order created event to kafka with id {}", orderCreatedEvent.getOrder().getId());
            } else {
                RecordMetadata recordMetadata = sendResult.getRecordMetadata();
                log.info("Record metadata: topic={}, partition={}, offset={} of order created event with id={}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), orderCreatedEvent.getOrder().getId());
            }
        };
    }
}
