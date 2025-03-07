package com.rolandsall.kafka.template.publisher.order;

import com.rolandsall.kafka.template.event.OrderCreatedEvent;
import com.rolandsall.kafka.template.order.avro.model.OrderAvroModel;
import com.rolandsall.kafka.template.order.avro.model.OrderItem;
import com.rolandsall.kafka.template.order.avro.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageMapper {

    public OrderAvroModel mapToAvroModel(OrderCreatedEvent orderCreatedEvent) {
        return OrderAvroModel.newBuilder()
                .setId(orderCreatedEvent.getOrder().getId())
                .setOrderStatus(OrderStatus.PENDING)
                .setTrackingId(orderCreatedEvent.getOrder().getTrackingId().getId())
                .setOrderItemList(orderCreatedEvent.getOrder().getOrderItemList().stream().map(orderItem -> OrderItem.newBuilder()
                        .setOrderId(orderCreatedEvent.getOrder().getId())
                        .setOrderItemId(orderItem.getOrderItemId())
                        .setProductId(orderItem.getProductId())
                        .setQuantity(orderItem.getQuantity())
                        .setPrice(orderItem.getPrice().longValue())
                        .build()).collect(java.util.stream.Collectors.toList()))
                .setCreatedAt(orderCreatedEvent.getCreatedAt().toInstant())
                .build();
    }

}
