package com.rolandsall.kafka.template.event;

import com.rolandsall.kafka.template.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class OrderEvent implements DomainEvent<Order> {
    private Order order;
    private ZonedDateTime createdAt;


}
