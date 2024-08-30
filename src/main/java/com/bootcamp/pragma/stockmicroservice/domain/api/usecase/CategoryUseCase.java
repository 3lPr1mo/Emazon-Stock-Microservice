package com.bootcamp.pragma.stockmicroservice.domain.api.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.util.Constants;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        if(categoryPersistencePort.findCategoryByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistError(category.getName());
        }
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public ContentPage<Category> findAllCategoriesPage(int page, int size, boolean isAsc) {
        ContentPage<Category> contentPage = categoryPersistencePort.findAllCategories(page, size, isAsc);
        if (contentPage.getContent().isEmpty()){
            throw new NoDataFoundException(Constants.NO_DATA_FOUND_CATEGORY_EXCEPTION_MESSAGE);
        }
        return  contentPage;
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryPersistencePort.findCategoryByName(name).orElseThrow(() -> new NoDataFoundException(Constants.NO_DATA_FOUND_CATEGORY_EXCEPTION_MESSAGE));
    }

}
