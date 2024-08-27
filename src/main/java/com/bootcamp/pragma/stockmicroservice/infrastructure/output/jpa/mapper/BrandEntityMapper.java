package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {
    BrandEntity modelToBranEntity(Brand brand);
    Brand entityToBrandModel(BrandEntity brandEntity);
}
