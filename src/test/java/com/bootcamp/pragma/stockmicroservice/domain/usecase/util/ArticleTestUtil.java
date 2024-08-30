package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;

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
}
