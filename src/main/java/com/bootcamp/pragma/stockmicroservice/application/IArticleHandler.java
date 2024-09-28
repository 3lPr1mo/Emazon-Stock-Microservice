package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.UpdateStockArticleRequest;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.ArticleResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface IArticleHandler {
    void create(CreateArticle createArticle);
    ContentPage<ArticleResponse> findAllArticles(int page, int size, boolean isAsc, String sortBy);
    void updateStock(UpdateStockArticleRequest request);
}
