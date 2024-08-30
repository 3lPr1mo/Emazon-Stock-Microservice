package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

import java.util.List;

public class ArticleTestUtil {
    private ArticleTestUtil() {}

    public static Article generateArticle() {
        return new Article(
                1L,
                1,
                20.0,
                CategoryTestUtil.generateCategories(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithOutCategory() {
        return new Article(
                1L,
                1,
                20.0,
                List.of(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithAboveCategoriesLimit() {
        return new Article(
                1L,
                1,
                20.0,
                CategoryTestUtil.generateMoreThanThreeCategories(),
                BrandTestUtil.generateBrand()
        );
    }

    public static Article generateArticleWithDuplicateCategories() {
        return new Article(
                1L,
                1,
                20.0,
                List.of(CategoryTestUtil.generateCategoy(), CategoryTestUtil.generateCategoy()),
                BrandTestUtil.generateBrand()
        );
    }
}
