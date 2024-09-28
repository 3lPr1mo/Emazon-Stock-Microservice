package com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller;

import com.bootcamp.pragma.stockmicroservice.application.IArticleHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.UpdateStockArticleRequest;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.AddStockArticleResponse;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.ArticleResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<ContentPage<ArticleResponse>> findAllArticles(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam boolean isAsc,
            @RequestParam String sortBy
    ) {
        return ResponseEntity.ok(articleHandler.findAllArticles(page, size, isAsc, sortBy));
    }

    @PutMapping
    public ResponseEntity<AddStockArticleResponse> addStockToArticle(@Valid @RequestBody UpdateStockArticleRequest request){
        articleHandler.updateStock(request);
        return ResponseEntity.status(HttpStatus.OK).body(new AddStockArticleResponse(true));
    }

}
