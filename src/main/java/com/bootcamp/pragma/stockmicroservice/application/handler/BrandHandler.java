package com.bootcamp.pragma.stockmicroservice.application.handler;

import com.bootcamp.pragma.stockmicroservice.application.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.application.mapper.BrandMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
