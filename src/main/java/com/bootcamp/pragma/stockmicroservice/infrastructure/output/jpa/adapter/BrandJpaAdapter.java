package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.BrandEntity;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Override
    public ContentPage<Brand> findAllBrands(int page, int size, boolean isAsc) {
        Sort sort = isAsc ? Sort.by("name").ascending() : Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<BrandEntity> brandsPage = brandRepository.findAll(pageable);
        List<Brand> brands = brandEntityMapper.entityToBrandModelList(brandsPage.getContent());
        return new ContentPage<>(
                brandsPage.getTotalPages(),
                brandsPage.getTotalElements(),
                brandsPage.getPageable().getPageNumber(),
                brandsPage.getPageable().getPageSize(),
                brandsPage.isFirst(),
                brandsPage.isLast(),
                brands
        );
    }
}
