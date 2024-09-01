package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.ArticleUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.exception.DuplicateCategoriesException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.ExcessiveCategoriesException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.InsufficientCategoriesException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.util.ArticleTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ArticleUseCaseTest {

    @Mock
    private IArticlePersistencePort articlePersistencePort;
    @Mock
    private ICategoryServicePort categoryServicePort;
    private ArticleUseCase articleUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        articleUseCase = new ArticleUseCase(articlePersistencePort, categoryServicePort);
    }

    @Test
    void shouldSaveArticleWhenCategoeriesAreUniqueAndInTheLimit() {
        Article article = ArticleTestUtil.generateArticle();
        articleUseCase.saveArticle(article);
        verify(articlePersistencePort, times(1)).save(article);
    }

    @Test
    void shouldThrowInsufficientCategoriesExceptionWhenCategoriesAreBelowTheLimit() {
        Article article = ArticleTestUtil.generateArticleWithOutCategory();
        assertThrows(InsufficientCategoriesException.class, () -> articleUseCase.saveArticle(article));
    }

    @Test
    void shouldThrowExcessiveCategoriesExceptionWhenCategoriesAreAboveTheLimit() {
        Article article = ArticleTestUtil.generateArticleWithAboveCategoriesLimit();
        assertThrows(ExcessiveCategoriesException.class, () -> articleUseCase.saveArticle(article));
    }

    @Test
    void shouldThrowDuplicateCategoriesExceptionWhenCategoriesAreNotUnique() {
        Article article = ArticleTestUtil.generateArticleWithDuplicateCategories();
        assertThrows(DuplicateCategoriesException.class, () -> articleUseCase.saveArticle(article));
    }

    @Test
    void shouldReturnArticlesWhenExistPageSortedByBrand() {
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        String sortBy = "brand";
        ContentPage<Article> expectedPage = ArticleTestUtil.generateArticlePage();
        when(articlePersistencePort.findAllArticles(page, size, isAsc, sortBy)).thenReturn(expectedPage);
        ContentPage<Article> actualPage = articleUseCase.findAllArticles(page, size, isAsc, sortBy);
        verify(articlePersistencePort, times(1)).findAllArticles(page,size,isAsc,sortBy);
        assertEquals(expectedPage, actualPage);
    }
}
