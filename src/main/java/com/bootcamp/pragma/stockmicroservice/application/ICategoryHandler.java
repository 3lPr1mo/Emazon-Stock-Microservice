package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface ICategoryHandler {
    void create(CreateCategory categoryRequest);
    ContentPage<CategoryResponse> findAll(int page, int size, boolean isAsc);
}
