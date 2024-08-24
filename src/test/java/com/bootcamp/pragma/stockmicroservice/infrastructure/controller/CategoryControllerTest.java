package com.bootcamp.pragma.stockmicroservice.infrastructure.controller;

import com.bootcamp.pragma.stockmicroservice.application.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.application.handler.CategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.mapper.CategoryMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler.CategoryControllerAdvisor;
import com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler.ExceptionResponse;
import com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller.CategoryController;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryControllerTest {

    @Mock
    private ICategoryHandler categoryHandler;
    @Mock
    private ICategoryServicePort categoryServicePort;
    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    private CategoryController categoryController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        categoryHandler = mock(CategoryHandler.class);
        categoryController = new CategoryController(categoryHandler);
        categoryServicePort = mock(ICategoryServicePort.class);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new CategoryControllerAdvisor())
                .build();
    }

    @Test
    void createNewCategory() {
        CreateCategory categoryRequest = new CreateCategory("Comida", "para comer comida comiendo");
        ResponseEntity<Void> response = categoryController.saveCategory(categoryRequest);
        verify(categoryHandler, times(1)).create(categoryRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getAllCategories() {
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        ResponseEntity<ContentPage<CategoryResponse>> response = categoryController.getAllCategories(page, size, isAsc);
        verify(categoryHandler, times(1)).findAll(page, size, isAsc);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
