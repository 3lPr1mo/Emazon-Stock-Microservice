package com.bootcamp.pragma.stockmicroservice.infrastructure.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BrandControllerTest {

    private BrandController brandController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void createNewBrand() {
        CreateBrand brandRequest = new CreateBrand("Apple", "Pc's");
    }

}
