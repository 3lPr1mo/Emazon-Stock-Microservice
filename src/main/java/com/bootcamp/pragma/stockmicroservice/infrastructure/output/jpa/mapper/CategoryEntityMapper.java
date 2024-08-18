package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper;

import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity categoryModelToEntity(Category category);
    Category categoryEntityToModel(CategoryEntity category);
}
