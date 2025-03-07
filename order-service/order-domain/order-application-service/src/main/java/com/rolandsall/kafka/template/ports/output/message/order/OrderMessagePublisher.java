package com.rolandsall.kafka.template.ports.output.message.order;

import com.rolandsall.kafka.template.event.OrderCreatedEvent;

public interface OrderMessagePublisher {

    void publish (OrderCreatedEvent event);
}
