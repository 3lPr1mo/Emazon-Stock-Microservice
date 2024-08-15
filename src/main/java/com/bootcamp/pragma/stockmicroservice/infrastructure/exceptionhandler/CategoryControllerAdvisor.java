package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.exceptionhandler;

import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.exception.CategoryAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class CategoryControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryAlreadyExist.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistException(CategoryAlreadyExist categoryAlreadyExist) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXIST.getMessage()));
    }

}
