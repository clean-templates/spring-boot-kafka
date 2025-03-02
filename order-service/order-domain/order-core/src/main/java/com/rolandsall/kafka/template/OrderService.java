package com.rolandsall.kafka.template;

import com.rolandsall.kafka.template.entity.Order;
import com.rolandsall.kafka.template.event.OrderCreatedEvent;

public interface OrderService {

    OrderCreatedEvent createOrder(Order order);
}
