package com.bootcamp.pragma.stockmicroservice.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryItemResponse {
    private Long id;
    private String name;
}
