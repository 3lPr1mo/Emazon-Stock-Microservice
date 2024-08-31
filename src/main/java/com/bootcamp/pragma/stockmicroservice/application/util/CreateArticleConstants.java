package com.bootcamp.pragma.stockmicroservice.application.util;

public class CreateArticleConstants {
    private CreateArticleConstants() {}


    public static final String NAME_IS_MANDATORY = "Name is mandatory";
    public static final String DESCRIPTION_IS_MANDATORY = "Description is mandatory";
    public static final int NAME_MAX_LENGTH_VALUE = 90;
    public static final int DESCRIPTION_MAX_LENGTH_VALUE = 120;
    public static final String NAME_MAX_LENGTH_MESSAGE = "Name max length is "+NAME_MAX_LENGTH_VALUE;
    public static final String DESCRIPTION_MAX_LENGTH_MESSAGE = "Description max length is "+DESCRIPTION_MAX_LENGTH_VALUE;
    public static final String QUANTITY_MUST_TO_BE_POSITIVE_OR_ZERO = "Quantity must be positive or zero";
    public static final String CATEGORIES_MUST_NOT_BE_EMPTY = "Article must to have at least one category";
    public static final String BRAND_IS_MANDATORY = "Brand is mandatory";
}
