package com.bootcamp.pragma.stockmicroservice.domain.api.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;

import java.util.Optional;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }

}
