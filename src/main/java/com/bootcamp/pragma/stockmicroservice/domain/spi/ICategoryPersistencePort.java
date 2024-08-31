package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import java.util.Optional;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
    Optional<Category> findCategoryByName(String name);
    ContentPage<Category> findAllCategories(int page, int size, boolean isAsc);
    Optional<Category> findCategoryById(Long id);
}
