package dev.ayush.exceptionlab.exception;

public class InvalidAccountException extends BankException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
