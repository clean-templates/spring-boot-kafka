package com.rolandsall.kafka.template.application.controller;


import com.rolandsall.kafka.template.application.controller.request.CreateOrderApiRequest;
import com.rolandsall.kafka.template.mediator.IMediator;
import com.rolandsall.kafka.template.order.CreateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final IMediator mediator;

    @Override
    public ResponseEntity<CreateOrderResponse> createOrder(CreateOrderApiRequest createOrderCommand) {
        mediator.handle(mapToCreateOrderCommand(createOrderCommand));
        return ResponseEntity.noContent().build();
    }


    private CreateOrderCommand mapToCreateOrderCommand(CreateOrderApiRequest request) {
        CreateOrderCommand.OrderAddressCommand address = CreateOrderCommand.OrderAddressCommand.builder()
                .street(request.getAddress().getStreet())
                .postalCode(request.getAddress().getPostalCode())
                .city(request.getAddress().getCity())
                .build();

        List<CreateOrderCommand.OrderItemCommand> orderItems = request.getOrderItems().stream()
                .map(item -> CreateOrderCommand.OrderItemCommand.builder()
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .price(item.getPrice())
                        .build())
                .collect(Collectors.toList());

        return CreateOrderCommand.builder()
                .address(address)
                .orderItems(orderItems)
                .build();
    }
}
