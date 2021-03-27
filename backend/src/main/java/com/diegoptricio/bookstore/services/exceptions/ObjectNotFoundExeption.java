package com.diegoptricio.bookstore.services.exceptions;

public class ObjectNotFoundExeption extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExeption(String message) {
        super(message);
    }

    public ObjectNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
