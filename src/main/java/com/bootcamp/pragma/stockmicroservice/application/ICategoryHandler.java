package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryHandler {
    void create(CreateCategory categoryRequest);
    List<CategoryResponse> findAll(int page, int size, boolean isAsc);
}
