package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

import com.bootcamp.pragma.stockmicroservice.infrastructure.exception.CategoryAlreadyExist;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CategoryControllerAdvisor {

    @ExceptionHandler(CategoryAlreadyExist.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistException(CategoryAlreadyExist categoryAlreadyExist) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap("message", "Category already exist"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();
        String error = "error";
        if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException){
            String message = ex.getCause().getMessage();

            if(message.contains("Duplicate entry")){
                response.put(error, "Name already exist");
            } else {
                response.put(error, "Error data integrity");
            }
        } else {
            response.put(error, "Error data integrity");
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
