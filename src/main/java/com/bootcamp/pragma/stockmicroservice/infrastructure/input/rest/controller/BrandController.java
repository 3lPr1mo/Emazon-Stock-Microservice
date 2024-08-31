package com.bootcamp.pragma.stockmicroservice.infrastructure.input.rest.controller;

import com.bootcamp.pragma.stockmicroservice.application.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.application.dto.request.CreateBrand;
import com.bootcamp.pragma.stockmicroservice.application.dto.response.BrandResponse;
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
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final IBrandHandler brandHandler;

    @Operation(summary = "Save new brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brand saved",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreateBrand.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid brand",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)) })
    })
    @PostMapping
    public ResponseEntity<Void> saveBrand(@Valid @RequestBody CreateBrand createBrand) {
        brandHandler.create(createBrand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<ContentPage<BrandResponse>> getAllBrands(
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_SIZE) int size,
            @RequestParam(defaultValue = CategoryConstants.FIND_CATEGORIES_DEFAULT_IS_ASC) boolean isAsc
    ) {
        return ResponseEntity.ok(brandHandler.findAllBrands(page, size, isAsc));
    }

}
