package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

public interface IArticleServicePort {
    void saveArticle(Article article);
}
