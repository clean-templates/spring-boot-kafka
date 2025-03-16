package com.rolandsall.kafka.template.infrastructure.messaging;

import com.rolandsall.kafka.template.consumer.KafkaConsumer;
import debezium.schema.customer.Envelope;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMessageListener implements KafkaConsumer<Envelope> {

    @Override
    @KafkaListener(topics = "debezium.schema.customer", groupId = "customer-group-id")
    public void receive(@Payload List<Envelope> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<Long> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        messages.forEach(envelope -> {
            System.out.println("Received customer with id: " + envelope.getAfter());
        });
    }
}
