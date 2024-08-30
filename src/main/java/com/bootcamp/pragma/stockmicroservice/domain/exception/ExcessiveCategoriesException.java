package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class ExcessiveCategoriesException extends RuntimeException {
    public ExcessiveCategoriesException(String message) {
        super(message);
    }
}
