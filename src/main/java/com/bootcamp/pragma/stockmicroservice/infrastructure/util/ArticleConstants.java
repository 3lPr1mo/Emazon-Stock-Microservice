package com.bootcamp.pragma.stockmicroservice.infrastructure.util;

import java.util.HashMap;
import java.util.Map;

public class ArticleConstants {
    private ArticleConstants() {}

    private static final Map<String, String> sortMappingArticle = new HashMap<>() {{
        put("brand", "brand.name");
        put("category", "categories.name");
        put("article", "name");
    }};

    public static String getValueSortMappingArticle(String field) {
        return sortMappingArticle.getOrDefault(field, "name");
    }
}
