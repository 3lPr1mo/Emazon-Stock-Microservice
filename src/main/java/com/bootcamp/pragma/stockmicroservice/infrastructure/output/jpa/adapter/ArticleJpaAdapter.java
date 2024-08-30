package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.ArticleEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistencePort {

    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

    @Override
    public void save(Article article) {
        //TODO: Save on repository
    }
}
