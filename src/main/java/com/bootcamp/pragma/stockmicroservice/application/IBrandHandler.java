package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;

public interface IBrandHandler {
    void create(CreateBrand createBrand);
}
