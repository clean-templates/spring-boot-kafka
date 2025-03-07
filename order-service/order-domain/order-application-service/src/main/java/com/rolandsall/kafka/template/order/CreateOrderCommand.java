package com.rolandsall.kafka.template.order;

import com.rolandsall.kafka.template.mediator.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderCommand implements Command {
    private List<OrderItemCommand> orderItems;
    private OrderAddressCommand address;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderAddressCommand {
        private String street;
        private String postalCode;
        private String city;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderItemCommand {
        private String productId;
        private Integer quantity;
        private BigDecimal price;
    }

}

