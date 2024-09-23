package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

import java.util.List;

public class ArticleTestUtil {
    private ArticleTestUtil() {}

    public static Article generateArticle() {
        return new Article(
                1L,
                "a",
                "asdad",
                1,
                20.0,
                CategoryTestUtil.generateCategories(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithOutCategory() {
        return new Article(
                1L,
                "a",
                "asdad",
                1,
                20.0,
                List.of(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithAboveCategoriesLimit() {
        return new Article(
                1L,
                "a",
                "asdad",
                1,
                20.0,
                CategoryTestUtil.generateMoreThanThreeCategories(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithDuplicateCategories() {
        return new Article(
                1L,
                "a",
                "asdad",
                1,
                20.0,
                List.of(CategoryTestUtil.generateCategoy(), CategoryTestUtil.generateCategoy()),
                BrandTestUtil.generateBrand()
        );
    }

    public static ContentPage<Article> generateArticlePage() {
        return new ContentPage<>(
          1,
          2,
          0,
          10,
          true,
          true,
          generateArticles()
        );
    }

    public static ContentPage<Article> generateArticleEmpty() {
        return new ContentPage<>(
                1,
                2,
                0,
                10,
                true,
                true,
                List.of()
        );
    }

    public static List<Article> generateArticles() {
        return List.of(
                generateArticle(),
                generateArticle(),
                generateArticle()
        );
    }
}
