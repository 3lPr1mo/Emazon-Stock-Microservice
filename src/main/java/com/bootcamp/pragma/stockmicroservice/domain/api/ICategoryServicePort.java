package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;

public interface ICategoryServicePort {
    void saveCategory(Category category);
}
