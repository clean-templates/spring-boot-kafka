package com.rolandsall.kafka.template.application.controller;
import com.rolandsall.kafka.template.application.controller.request.CreateOrderApiRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public interface OrderApi {

    @PostMapping
    @Operation(summary = "Create a new order")
    @ApiResponse(responseCode = "200", description = "Order created successfully")
    @ApiResponse(responseCode = "500", description = "Error while creating order")
    ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody CreateOrderApiRequest createOrderCommand);
}
