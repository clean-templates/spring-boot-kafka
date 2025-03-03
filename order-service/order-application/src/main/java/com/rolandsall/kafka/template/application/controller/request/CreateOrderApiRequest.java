package com.rolandsall.kafka.template.application.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderApiRequest {
    private List<OrderItemApiRequest> orderItems;
    private OrderAddressApiRequest address;
}
