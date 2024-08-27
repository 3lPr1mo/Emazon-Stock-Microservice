package com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller;

import com.bootcamp.pragma.stockmicroservice.application.ICategoryHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateCategory;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.infrastructure.exceptionhandler.ExceptionResponse;
import com.bootcamp.pragma.stockmicroservice.infrastructure.util.CategoryConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Save new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category saved",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateCategory.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid category",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)) })
    })
    @PostMapping
    public ResponseEntity<Void> saveCategory(@Valid @RequestBody CreateCategory createCategory){
        categoryHandler.create(createCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Returns paged categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ContentPage.class)) }),
            @ApiResponse(responseCode = "404", description = "No categories found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)) })
    })
    @GetMapping("")
    public ResponseEntity<ContentPage<CategoryResponse>> getAllCategories(
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_SIZE) int size,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_IS_ASC) boolean isAsc
    ){
        return ResponseEntity.ok(categoryHandler.findAll(page, size, isAsc));
    }

}
