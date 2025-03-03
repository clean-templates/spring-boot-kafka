package com.rolandsall.kafka.template.mediator.command;

public class CommandHandlerNotFoundException extends RuntimeException {

    public CommandHandlerNotFoundException(Command cmd) {
        super("No handler found for command: " + cmd.getClass().getName());
    }
}
