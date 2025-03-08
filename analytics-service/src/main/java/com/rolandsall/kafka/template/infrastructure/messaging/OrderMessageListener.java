package com.rolandsall.kafka.template.infrastructure.messaging;

import com.rolandsall.kafka.template.consumer.KafkaConsumer;
import com.rolandsall.kafka.template.order.avro.model.OrderAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderMessageListener implements KafkaConsumer<OrderAvroModel> {

    @Override
    @KafkaListener(topics = "order", groupId = "${kafka-consumer-config.order-group-id}")
    public void receive(@Payload List<OrderAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<Long> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        messages.forEach(orderAvroModel -> {
            log.info("Received order with id: {}", orderAvroModel);
        });

    }
}
