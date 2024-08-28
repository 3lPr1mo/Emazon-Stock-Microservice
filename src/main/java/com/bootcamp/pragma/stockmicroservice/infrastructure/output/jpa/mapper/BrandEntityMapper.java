package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {
    BrandEntity modelToBranEntity(Brand brand);
    Brand entityToBrandModel(BrandEntity brandEntity);
    List<Brand> entityToBrandModelList(List<BrandEntity> brandEntityList);
}
