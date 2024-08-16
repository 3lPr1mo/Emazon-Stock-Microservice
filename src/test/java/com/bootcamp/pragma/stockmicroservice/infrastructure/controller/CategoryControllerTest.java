package com.bootcamp.pragma.stockmicroservice.infrastructure.controller;

import com.bootcamp.pragma.stockmicroservice.application.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.handler.CategoryHandler;
import com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller.CategoryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    @Mock
    private ICategoryHandler categoryHandler;
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        categoryHandler = mock(CategoryHandler.class);
        categoryController = new CategoryController(categoryHandler);
    }

    @Test
    void createNewCategory() {
        CreateCategory categoryRequest = new CreateCategory("Comida", "para comer comida comiendo");
        ResponseEntity<Void> response = categoryController.saveCategory(categoryRequest);
        verify(categoryHandler, times(1)).create(categoryRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
