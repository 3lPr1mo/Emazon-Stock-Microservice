package com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller;

import com.bootcamp.pragma.stockmicroservice.application.IArticleHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final IArticleHandler articleHandler;

    @PostMapping
    public ResponseEntity<Void> saveArticle(@Valid @RequestBody CreateArticle createArticle) {
        articleHandler.create(createArticle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
