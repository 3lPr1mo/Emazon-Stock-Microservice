package com.bootcamp.pragma.stockmicroservice.domain.util;

public class ArticleConstants {
    private ArticleConstants() {}

    public static final int MIN_CATEGORIES = 1;
    public static final int MAX_CATEGORIES = 3;
    public static final String MIN_CATEGORIES_MESSAGE = "Minimum categories must be " + MIN_CATEGORIES;
    public static final String MAX_CATEGORIES_MESSAGE = "Maximum categories must be " + MAX_CATEGORIES;
}
