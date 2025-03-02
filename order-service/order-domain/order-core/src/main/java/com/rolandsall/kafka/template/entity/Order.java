package com.rolandsall.kafka.template.entity;

import com.rolandsall.kafka.template.exception.OrderDomainException;
import com.rolandsall.kafka.template.valueobject.TrackingId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private String id;
    private TrackingId trackingId;
    private OrderStatus orderStatus;

    public void validateOrder() {
        if (orderStatus != null || getId() != null || trackingId != null) {
            throw new OrderDomainException("Order is not in correct state for initialization!");
        }
    }

    public void initialize() {
        id = UUID.randomUUID().toString();
        trackingId = TrackingId.createTrackingId(id);
        orderStatus = OrderStatus.PENDING;
    }
}
