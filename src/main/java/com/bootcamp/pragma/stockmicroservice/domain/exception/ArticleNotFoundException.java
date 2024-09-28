package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(final String message) {
        super(message);
    }
}
