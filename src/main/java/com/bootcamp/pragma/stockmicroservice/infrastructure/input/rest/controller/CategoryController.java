package com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller;

import com.bootcamp.pragma.stockmicroservice.application.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.infrastructure.util.CategoryConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryHandler categoryHandler;

    @PostMapping
    public ResponseEntity<Void> saveCategory(@Valid @RequestBody CreateCategory createCategory){
        categoryHandler.create(createCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_SIZE) int size,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_IS_ASC) boolean isAsc
    ){
        return ResponseEntity.ok(categoryHandler.findAll(page, size, isAsc));
    }

}
