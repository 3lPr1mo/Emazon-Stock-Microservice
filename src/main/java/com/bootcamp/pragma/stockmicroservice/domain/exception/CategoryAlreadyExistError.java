package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class CategoryAlreadyExistError extends RuntimeException {
    public CategoryAlreadyExistError(String message) {
        super(message);
    }
}
