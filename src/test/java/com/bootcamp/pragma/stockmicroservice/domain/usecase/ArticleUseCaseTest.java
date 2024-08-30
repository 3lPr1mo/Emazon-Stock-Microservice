package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.ArticleUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.util.ArticleTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ArticleUseCaseTest {

    @Mock
    private IArticlePersistencePort articlePersistencePort;
    private ArticleUseCase articleUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        articleUseCase = new ArticleUseCase(articlePersistencePort);
    }

    @Test
    void shouldSaveArticle() {
        Article article = ArticleTestUtil.generateArticle();
        articleUseCase.saveArticle(article);
        verify(articlePersistencePort, times(1)).save(article);
    }
}
