package com.bootcamp.pragma.stockmicroservice.domain.api.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ExcessiveCategoriesException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.InsufficientCategoriesException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.util.ArticleConstants;

public class ArticleUseCase implements IArticleServicePort {

    private IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void saveArticle(Article article) {
        if(article.getCategories().size() < ArticleConstants.MIN_CATEGORIES){
            throw new InsufficientCategoriesException(ArticleConstants.MIN_CATEGORIES_MESSAGE);
        }
        if (article.getCategories().size() > ArticleConstants.MAX_CATEGORIES){
            throw new ExcessiveCategoriesException(ArticleConstants.MAX_CATEGORIES_MESSAGE);
        }
        articlePersistencePort.save(article);
    }
}
