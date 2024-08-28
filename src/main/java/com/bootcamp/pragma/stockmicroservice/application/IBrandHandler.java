package com.bootcamp.pragma.stockmicroservice.application;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface IBrandHandler {
    void create(CreateBrand createBrand);
    ContentPage<BrandResponse> findAllBrands(int page, int size, boolean isAsc);
}
