package com.rolandsall.kafka.template.mediator.command;

public class Result {
    private final boolean isSuccess;
    private final boolean isFailure;
    private final String errorMessage;

    private Result(boolean isSuccess, boolean isFailure, String errorMessage) {
        this.isSuccess = isSuccess;
        this.isFailure = isFailure;
        this.errorMessage = errorMessage;
    }

    public static Result success() {
        return new Result(true, false, null);
    }

    public static Result failure(String errorMessage) {
        return new Result(false, true, errorMessage);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}