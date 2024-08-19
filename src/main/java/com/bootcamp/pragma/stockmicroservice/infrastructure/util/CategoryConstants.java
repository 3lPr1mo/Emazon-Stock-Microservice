package com.bootcamp.pragma.stockmicroservice.infrastructure.util;

public class CategoryConstants {
    private CategoryConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FIND_CATEGORIES_DEFAULT_PAGE = "0";
    public static final String FIND_CATEGORIES_DEFAULT_SIZE = "10";
    public static final String FIND_CATEGORIES_DEFAULT_IS_ASC = "true";
}
