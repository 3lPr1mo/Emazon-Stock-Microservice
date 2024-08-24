package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.CategoryUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.util.CategoryTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    void shouldReturnAllCategoriesPaged(){
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        ContentPage<Category> expectedPage = CategoryTestUtil.generateContentPageCategory();
        when(categoryPersistencePort.findAllCategories(page, size, isAsc)).thenReturn(expectedPage);
        ContentPage<Category> actualPage = categoryUseCase.findAllCategoriesPage(page, size, isAsc);
        verify(categoryPersistencePort, times(1)).findAllCategories(page, size, isAsc);
        assertEquals(expectedPage, actualPage);
    }

    @Test
    void shouldThrowErrorWhenPageIsEmpty(){
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        when(categoryPersistencePort.findAllCategories(page, size, isAsc)).thenReturn(CategoryTestUtil.generateEmptyContentPageCategory());
        assertThrows(NoDataFoundException.class, () -> categoryUseCase.findAllCategoriesPage(page, size, isAsc));
    }

}
