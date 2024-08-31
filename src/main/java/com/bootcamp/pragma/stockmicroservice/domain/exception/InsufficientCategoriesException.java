package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class InsufficientCategoriesException extends RuntimeException {
    public InsufficientCategoriesException(String message) {
        super(message);
    }
}
