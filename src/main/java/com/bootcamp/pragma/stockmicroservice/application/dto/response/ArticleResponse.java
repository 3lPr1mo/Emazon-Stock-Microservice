package com.bootcamp.pragma.stockmicroservice.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private List<CategoryItemResponse> categories;
    private BrandItemResponse brand;
}
