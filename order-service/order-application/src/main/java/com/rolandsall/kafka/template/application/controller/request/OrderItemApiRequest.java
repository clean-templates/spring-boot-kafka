package com.rolandsall.kafka.template.application.controller.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemApiRequest {
    private String productId;
    @Min(1)
    private Integer quantity;
}
