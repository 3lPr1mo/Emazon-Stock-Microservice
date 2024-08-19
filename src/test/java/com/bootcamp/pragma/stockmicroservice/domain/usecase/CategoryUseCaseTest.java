package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.CategoryUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        categoryUseCase = new CategoryUseCase(categoryPersistencePort);
    }

    @Test
    void shouldSaveCategoryWhenNotExist() {
        Category category = new Category(1L, "Electrodomestico", "Cosas electricas");
        categoryUseCase.saveCategory(category);

        verify(categoryPersistencePort, times(1)).saveCategory(category);
    }

    @Test
    void shouldThrowErrorWhenCategoryExist(){
        Category category = new Category(1L, "Comida", "Pa' comer");
        when(categoryPersistencePort.findCategoryByName(category.getName())).thenReturn(Optional.of(category));
        assertThrows(CategoryAlreadyExistError.class, () -> categoryUseCase.saveCategory(category));
    }

    @Test
    void shouldReturnAllCategoriesWhenExist() {
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        List<Category> expectedCategories = List.of(
                new Category(1L, "Comida", "Para comer"),
                new Category(2L, "Electrodomesticos", "Para eletrificarse")
        );

        when(categoryPersistencePort.findAllCategories(page, size, isAsc)).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryUseCase.findAllCategories(page, size, isAsc);
        assertEquals(expectedCategories, actualCategories);
    }

}
