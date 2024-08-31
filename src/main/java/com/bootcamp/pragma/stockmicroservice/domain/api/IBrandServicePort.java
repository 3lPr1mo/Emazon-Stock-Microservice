package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    ContentPage<Brand> findAllBrands(int page, int size, boolean isAsc);
}
