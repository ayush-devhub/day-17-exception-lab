package dev.ayush.exceptionlab.exception;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
}
