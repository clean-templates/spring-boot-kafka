package com.rolandsall.kafka.template.mediator.command;

public interface CommandHandler<T extends Command> {
    Result handle(T command);
}
