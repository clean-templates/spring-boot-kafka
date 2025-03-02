package com.rolandsall.kafka.template.application.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderApiRequest {
    private OrderItemApiRequest orderItems;
    private OrderAddressApiRequest address;
}
