package com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler;

public enum ExceptionResponse {

    CATEGORY_ALREADY_EXIST("There is a category with the same name");

    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
