package com.bootcamp.pragma.stockmicroservice.application.mapper;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.ArticleResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, BrandMapper.class})
public interface ArticleMapper {
    @Mapping(target = "id", ignore = true)
    Article requestToArticleModel(CreateArticle createArticle);

    ArticleResponse articleToArticleResponse(Article article);
    List<ArticleResponse> modelToArticleResponseList(List<Article> articles);
    ContentPage<ArticleResponse> modelToArticleResponsePage(ContentPage<Article> articleContentPage);
}
