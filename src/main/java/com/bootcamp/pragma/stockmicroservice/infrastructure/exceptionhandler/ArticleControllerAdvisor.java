package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

import com.bootcamp.pragma.stockmicroservice.application.dto.response.AddStockArticleResponse;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ArticleNotFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ArticlePageSortByIsInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ArticleControllerAdvisor {

    @ExceptionHandler(ArticlePageSortByIsInvalidException.class)
    public ResponseEntity<ExceptionResponse> handleArticlePageSortByIsInvalidException(ArticlePageSortByIsInvalidException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<AddStockArticleResponse> handleArticleNotFoundException(ArticleNotFoundException ex) {
        return ResponseEntity.badRequest().body(new AddStockArticleResponse(false));
    }

}
