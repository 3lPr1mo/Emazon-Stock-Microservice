package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    @Override
    public void saveCategory(Category category) {
        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistError(category.getName());
        }
        categoryRepository.save(categoryEntityMapper.categoryModelToEntity(category));
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findByName(name).map(categoryEntityMapper::categoryEntityToModel);
    }
}
