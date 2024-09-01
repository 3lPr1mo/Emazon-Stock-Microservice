package com.bootcamp.pragma.stockmicroservice.application.mapper;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.ArticleResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    @Mapping(target = "id", ignore = true)
    Article requestToArticleModel(CreateArticle createArticle);

    ArticleResponse articleToArticleResponse(Article article);
}
