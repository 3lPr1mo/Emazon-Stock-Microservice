package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class ArticlePageSortByIsInvalidException extends RuntimeException {
    public ArticlePageSortByIsInvalidException(String message) {
        super(message);
    }
}
