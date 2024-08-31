package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.exception.CategoryAlreadyExistError;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.ICategoryPersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    @Override
    public void saveCategory(Category category) {
        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistError(category.getName());
        }
        categoryRepository.save(categoryEntityMapper.categoryModelToEntity(category));
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findByName(name).map(categoryEntityMapper::categoryEntityToModel);
    }

    @Override
    public ContentPage<Category> findAllCategories(int page, int size, boolean isAsc) {
        Sort sort = isAsc ? Sort.by("name").ascending() : Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CategoryEntity> cateogryPage = categoryRepository.findAll(pageable);
        List<Category> category = categoryEntityMapper.toModelList(cateogryPage.getContent());
        return new ContentPage<>(
                cateogryPage.getTotalPages(),
                cateogryPage.getTotalElements(),
                cateogryPage.getPageable().getPageNumber(),
                cateogryPage.getPageable().getPageSize(),
                cateogryPage.isFirst(),
                cateogryPage.isLast(),
                category
        );
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id).map(categoryEntityMapper::categoryEntityToModel);
    }

}
