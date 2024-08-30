package com.bootcamp.pragma.stockmicroservice.application.handler;

import com.bootcamp.pragma.stockmicroservice.application.IArticleHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;
import com.bootcamp.pragma.stockmicroservice.application.mapper.ArticleMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler {

    private final ArticleMapper articleMapper;
    private final IArticleServicePort articleServicePort;

    @Override
    public void create(CreateArticle createArticle) {
        Article article = articleMapper.requestToArticleModel(createArticle);
        articleServicePort.saveArticle(article);
    }
}
