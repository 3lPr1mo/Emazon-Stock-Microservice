package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class DuplicateCategoriesException extends RuntimeException {
    public DuplicateCategoriesException(final String message) {
        super(message);
    }
}
