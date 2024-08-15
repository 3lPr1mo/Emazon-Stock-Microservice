package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;

public interface ICategoryHandler {
    void create(CreateCategory categoryRequest);
}
