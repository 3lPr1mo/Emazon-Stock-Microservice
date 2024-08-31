package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.ArticleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleEntityMapper {
    ArticleEntity modelToArticleEntity(Article article);
}
