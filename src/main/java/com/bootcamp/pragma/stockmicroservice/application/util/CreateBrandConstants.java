package com.bootcamp.pragma.stockmicroservice.application.util;

public class CreateBrandConstants {
    private CreateBrandConstants() {}

    public static final String NAME_IS_MANDATORY = "Name is mandatory";
    public static final String DESCRIPTION_IS_MANDATORY = "Description is mandatory";
    public static final int NAME_MAX_LENGTH_VALUE = 50;
    public static final int DESCRIPTION_MAX_LENGTH_VALUE = 120;
    public static final String NAME_MAX_LENGTH_MESSAGE = "Name max length is "+NAME_MAX_LENGTH_VALUE;
    public static final String DESCRIPTION_MAX_LENGTH_MESSAGE = "Description max length is "+DESCRIPTION_MAX_LENGTH_VALUE;
}
