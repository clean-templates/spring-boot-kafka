package com.rolandsall.kafka.template.exception;

public class OrderNotFoundException extends DomainException{

    public OrderNotFoundException(String message) {
        super(message);
    }
}
