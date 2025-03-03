package com.rolandsall.kafka.template.mediator;

import com.rolandsall.kafka.template.mediator.command.Command;
import com.rolandsall.kafka.template.mediator.command.Result;

public interface IMediator {

    <T extends Command> Result handle(T command);
}
