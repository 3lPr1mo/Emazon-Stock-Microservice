package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface IArticleServicePort {
    void saveArticle(Article article);
    ContentPage<Article> findAllArticles(int page, int size, boolean isAsc, String sortBy);
    void updateStockArticle(Long articleId, Integer quantity);
}
