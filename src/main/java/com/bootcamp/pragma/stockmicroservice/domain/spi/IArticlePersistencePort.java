package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface IArticlePersistencePort {
    void save(Article article);
    ContentPage<Article> findAllArticles(int page, int size, boolean isAsc, String sortBy);
}
