package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CategoryControllerAdvisor {

    @ExceptionHandler(CategoryAlreadyExistError.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistException(CategoryAlreadyExistError ex) {
        ExceptionResponse response = new ExceptionResponse(
          ex.getMessage(),
          HttpStatus.BAD_REQUEST.toString(),
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNoDataFoundException(NoDataFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

}
