package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateArticle;

public interface IArticleHandler {
    void create(CreateArticle createArticle);
}
