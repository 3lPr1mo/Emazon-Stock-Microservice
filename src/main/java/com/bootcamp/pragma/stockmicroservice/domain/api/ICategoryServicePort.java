package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface ICategoryServicePort {
    void saveCategory(Category category);
    ContentPage<Category> findAllCategoriesPage(int page, int size, boolean isAsc);
}
