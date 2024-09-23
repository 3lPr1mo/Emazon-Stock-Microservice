package com.bootcamp.pragma.stockmicroservice.application.mapper;

import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryItemResponse;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    Category categoryRequestToModel(CreateCategory createCategory);
    CategoryResponse modelToResponse(Category category);
    List<CategoryResponse> modelToResponseList(List<Category> categories);
    CategoryItemResponse modelToItemResponse(Category category);
    List<CategoryItemResponse> modelToItemResponseList(List<Category> categories);
}
