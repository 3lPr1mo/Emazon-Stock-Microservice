package com.bootcamp.pragma.stockmicroservice.application.mapper;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryRequestToModel(CreateCategory createCategory);

}
