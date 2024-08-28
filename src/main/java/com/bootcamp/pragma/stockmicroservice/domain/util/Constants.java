package com.bootcamp.pragma.stockmicroservice.domain.util;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION,
    }

    public static final String NO_DATA_FOUND_CATEGORY_EXCEPTION_MESSAGE = "No Data Found for 'category'";
    public static final String BRAND_ALREADY_EXISTS_MESSAGE = "Brand Already Exists";
    public static final String NO_DATA_FOUND_BRAND_EXCEPTION_MESSAGE = "No Data Found for 'brand'";
}
