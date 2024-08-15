package com.bootcamp.pragma.stockmicroservice.application.util;

public class CreateCategoryConstants {

    private CreateCategoryConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final int NAME_MAX_LENGTH_VALUE = 50;
    public static final int DESCRIPTION_MAX_LENGTH_VALUE = 90;
    public static final String NAME_IS_MANDATORY = "Name is mandatory";
    public static final String DESCRIPTION_IS_MANDATORY = "Description is mandatory";
    public static final String NAME_MAX_LENGHT = "Name max length is " + NAME_MAX_LENGTH_VALUE;
    public static final String DESCRIPTION_MAX_LENGTH = "Description max length is " + DESCRIPTION_MAX_LENGTH_VALUE;

}
