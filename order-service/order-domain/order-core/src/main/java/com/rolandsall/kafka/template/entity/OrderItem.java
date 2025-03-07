package com.rolandsall.kafka.template.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItem {
    private String orderId;
    private Integer orderItemId;
    private String productId;
    private Integer quantity;
    private BigDecimal price;

    void initialize(String orderId, Integer orderItemId) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
    }


}
