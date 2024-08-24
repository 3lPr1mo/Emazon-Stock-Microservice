package com.bootcamp.pragma.stockmicroservice.domain.api;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
}
