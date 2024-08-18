package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class CategoryFieldExceedsLimitError extends RuntimeException {
    public CategoryFieldExceedsLimitError(String message) {
        super(message);
    }
}
