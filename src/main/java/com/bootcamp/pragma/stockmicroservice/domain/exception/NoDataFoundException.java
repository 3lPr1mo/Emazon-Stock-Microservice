package com.bootcamp.pragma.stockmicroservice.domain.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(final String message) {
        super(message);
    }
}
