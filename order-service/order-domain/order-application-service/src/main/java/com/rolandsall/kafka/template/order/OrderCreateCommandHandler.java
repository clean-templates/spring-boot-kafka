package com.rolandsall.kafka.template.order;

import com.rolandsall.kafka.template.mediator.command.CommandHandler;
import com.rolandsall.kafka.template.mediator.command.Result;
import org.springframework.stereotype.Service;

@Service
public class OrderCreateCommandHandler implements CommandHandler<CreateOrderCommand> {

    @Override
    public Result handle(CreateOrderCommand command) {

        return Result.success();
    }
}
