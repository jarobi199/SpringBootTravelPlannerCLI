package io.travel.exception;

public class InvalidDayNumberException extends RuntimeException {
    public InvalidDayNumberException(String message) {
        super(message);
    }
}
