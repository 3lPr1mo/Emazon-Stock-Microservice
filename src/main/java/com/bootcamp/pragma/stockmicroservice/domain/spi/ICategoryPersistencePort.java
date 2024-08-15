package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
}
