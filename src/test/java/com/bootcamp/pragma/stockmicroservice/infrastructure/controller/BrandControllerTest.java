package com.bootcamp.pragma.stockmicroservice.infrastructure.controller;

import com.bootcamp.pragma.stockmicroservice.application.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller.BrandController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BrandControllerTest {

    private BrandController brandController;
    @Mock
    private IBrandHandler brandHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandController = new BrandController(brandHandler);
    }

    @Test
    void createNewBrand() {
        CreateBrand brandRequest = new CreateBrand("Apple", "Pc's");
        ResponseEntity<Void> response = brandController.saveBrand(brandRequest);
        verify(brandHandler, times(1)).create(brandRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
