package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistencePort {

    private final BrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public void save(Brand brand) {
        brandRepository.save(brandEntityMapper.modelToBranEntity(brand));
    }

    @Override
    public Optional<Brand> findByName(String name) {
        return brandRepository.findByName(name).map(brandEntityMapper::entityToBrandModel);
    }
}
