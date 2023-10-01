package io.digital101.exception;

public class OrderServiceException extends RuntimeException{
    public OrderServiceException() {
        super();
    }

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
