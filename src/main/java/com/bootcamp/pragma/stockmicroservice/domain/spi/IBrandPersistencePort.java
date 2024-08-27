package com.bootcamp.pragma.stockmicroservice.domain.spi;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;

import java.util.Optional;

public interface IBrandPersistencePort {
    void save(Brand brand);
    Optional<Brand> findByName(String name);
}
