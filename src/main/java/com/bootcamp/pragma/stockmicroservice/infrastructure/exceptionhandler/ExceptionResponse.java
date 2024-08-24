package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private final String message;
    private final String status;
    private final int statusCode;
    private final LocalDateTime timestamp;
}
