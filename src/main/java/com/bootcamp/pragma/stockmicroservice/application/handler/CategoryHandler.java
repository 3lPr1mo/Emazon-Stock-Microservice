package com.bootcamp.pragma.stockmicroservice.application.handler;

import com.bootcamp.pragma.stockmicroservice.application.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.application.mapper.CategoryMapper;
import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final CategoryMapper categoryMapper;

    @Override
    public void create(CreateCategory categoryRequest) {
        Category category = categoryMapper.categoryRequestToModel(categoryRequest);
        categoryServicePort.saveCategory(category);
    }

    @Override
    public ContentPage<CategoryResponse> findAll(int page, int size, boolean isAsc) {
        ContentPage<Category> categoryContentPage = categoryServicePort.findAllCategoriesPage(page, size, isAsc);
        List<Category> categories = categoryContentPage.getContent();
        List<CategoryResponse> categoryResponses = categoryMapper.modelToResponseList(categories);
        return new ContentPage<>(
                categoryContentPage.getTotalPage(),
                categoryContentPage.getTotalElements(),
                categoryContentPage.getPageNumber(),
                categoryContentPage.getPageSize(),
                categoryContentPage.isFirst(),
                categoryContentPage.isLast(),
                categoryResponses
        );
    }

}
