package com.rolandsall.kafka.template;

import com.rolandsall.kafka.template.entity.Order;
import com.rolandsall.kafka.template.event.OrderCreatedEvent;

public class OrderDomainService implements OrderService {

    @Override
    public OrderCreatedEvent createOrder(Order order) {
        order.validateOrder();
        order.initialize();
        return OrderCreatedEvent.builder()
                .order(order)
                .createdAt(TimeGeneratorFactory.now())
                .build();
    }
}
