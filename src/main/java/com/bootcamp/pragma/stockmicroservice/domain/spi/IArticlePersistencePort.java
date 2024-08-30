package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

public interface IArticlePersistencePort {
    void save(Article article);
}
