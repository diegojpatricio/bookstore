package com.diegoptricio.bookstore.services.exceptions;

public class ViolationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ViolationException(String message) {
        super(message);
    }

    public ViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
