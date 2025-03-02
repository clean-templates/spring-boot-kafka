package com.rolandsall.kafka.template.application.controller;


import com.rolandsall.kafka.template.application.controller.request.CreateOrderApiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {


    @Override
    public ResponseEntity<CreateOrderResponse> createOrder(CreateOrderApiRequest createOrderCommand) {
        // delegate to core application service
        return null;
    }
}
