package dev.ayush.exceptionlab.exception;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
