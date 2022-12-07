package com.enigmacamp.authjwt.exception;

public class UnathorizedException extends RuntimeException{
    public UnathorizedException() {
        super("Unauthorized");
    }

    public UnathorizedException(String message) {
        super(message);
    }
}
