package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

import com.bootcamp.pragma.stockmicroservice.infrastructure.exception.CategoryAlreadyExist;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CategoryControllerAdvisor {

    //private static final String MESSAGE = "Message";

    /*@ExceptionHandler(CategoryAlreadyExist.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistException(CategoryAlreadyExist categoryAlreadyExist) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXIST.getMessage()));
    }*/

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();
        System.out.println(ex.getCause());
        if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException){
            String message = ex.getCause().getMessage();

            if(message.contains("Duplicate entry")){
                response.put("error", "Name already exist");
            } else {
                response.put("error", "Error data integrity");
            }
        } else {
            response.put("error", "Error data integrity");
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
