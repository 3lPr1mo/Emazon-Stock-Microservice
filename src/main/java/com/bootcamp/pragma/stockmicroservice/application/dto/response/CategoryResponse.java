package com.bootcamp.pragma.stockmicroservice.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {
    private String name;
    private String description;
}
