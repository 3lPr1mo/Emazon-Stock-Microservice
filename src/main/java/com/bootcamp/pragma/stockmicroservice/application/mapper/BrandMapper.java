package com.bootcamp.pragma.stockmicroservice.application.mapper;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.BrandItemResponse;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    @Mapping(target = "id", ignore = true)
    Brand brandRequestToModel(CreateBrand createBrand);

    BrandResponse modelToBrandResponse(Brand brand);
    List<BrandResponse> modelToBrandResponseList(List<Brand> brands);
    ContentPage<BrandResponse> modelToBrandResponsePage(ContentPage<Brand> brandPage);
    BrandItemResponse modelToBrandItemResponse(Brand brand);
}
