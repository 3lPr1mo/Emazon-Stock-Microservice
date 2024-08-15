package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;

import java.util.Optional;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
}
