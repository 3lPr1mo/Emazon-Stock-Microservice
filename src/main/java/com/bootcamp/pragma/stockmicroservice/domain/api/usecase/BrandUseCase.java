package com.bootcamp.pragma.stockmicroservice.domain.api.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.exception.BrandAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.domain.exception.NoDataFoundException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.util.Constants;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand brand) {
        if(brandPersistencePort.findByName(brand.getName()).isPresent()) {
            throw new BrandAlreadyExistsException(Constants.BRAND_ALREADY_EXISTS_MESSAGE);
        }
        brandPersistencePort.save(brand);
    }

    @Override
    public ContentPage<Brand> findAllBrands(int page, int size, boolean isAsc) {
        ContentPage<Brand> contentPage = brandPersistencePort.findAllBrands(page, size, isAsc);
        if (contentPage.getContent().isEmpty()) {
            throw new NoDataFoundException(Constants.NO_DATA_FOUND_BRAND_EXCEPTION_MESSAGE);
        }
        return contentPage;
    }

}
