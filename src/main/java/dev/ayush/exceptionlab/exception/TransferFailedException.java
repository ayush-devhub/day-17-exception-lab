package dev.ayush.exceptionlab.exception;

public class TransferFailedException extends BankException {
    public TransferFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
