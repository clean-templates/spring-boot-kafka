package com.rolandsall.kafka.template.order;

import com.rolandsall.kafka.template.OrderService;
import com.rolandsall.kafka.template.entity.Order;
import com.rolandsall.kafka.template.entity.OrderItem;
import com.rolandsall.kafka.template.event.OrderCreatedEvent;
import com.rolandsall.kafka.template.mediator.command.CommandHandler;
import com.rolandsall.kafka.template.mediator.command.Result;
import com.rolandsall.kafka.template.ports.output.message.order.OrderMessagePublisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderCreateCommandHandler implements CommandHandler<CreateOrderCommand> {

    private final OrderService orderService;
    private final OrderMessagePublisher orderMessagePublisher;

    @Override
    public Result handle(CreateOrderCommand command) {
        OrderCreatedEvent order = orderService.createOrder(mapFromCommandToDomain(command));
        orderMessagePublisher.publish(order);
        return Result.success();
    }

    private Order mapFromCommandToDomain(CreateOrderCommand command) {
        return Order.builder()
                .orderItemList(command.getOrderItems().stream().map(item -> OrderItem.builder()
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .price(item.getPrice())
                        .build())
                        .toList())
                .build();
    }
}
