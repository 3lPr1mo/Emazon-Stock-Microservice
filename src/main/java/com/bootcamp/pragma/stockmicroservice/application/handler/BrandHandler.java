package com.bootcamp.pragma.stockmicroservice.application.handler;

import com.bootcamp.pragma.stockmicroservice.application.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.application.mapper.BrandMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandHandler implements IBrandHandler {

    private final BrandMapper brandMapper;
    private final IBrandServicePort brandServicePort;

    @Override
    public void create(CreateBrand createBrand) {
        Brand brand = brandMapper.brandRequestToModel(createBrand);
        brandServicePort.saveBrand(brand);
    }

    @Override
    public ContentPage<BrandResponse> findAllBrands(int page, int size, boolean isAsc) {
        ContentPage<Brand> brandContentPage = brandServicePort.findAllBrands(page, size, isAsc);
        return brandMapper.modelToBrandResponsePage(brandContentPage);
    }
}
