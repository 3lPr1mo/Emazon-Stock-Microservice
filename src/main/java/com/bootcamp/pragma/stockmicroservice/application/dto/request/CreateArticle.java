package com.bootcamp.pragma.stockmicroservice.application.dto.request;

import com.bootcamp.pragma.stockmicroservice.application.util.CreateArticleConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CreateArticle {
    @NotBlank(message = CreateArticleConstants.NAME_IS_MANDATORY)
    @NotNull(message = CreateArticleConstants.NAME_IS_MANDATORY)
    @Size(max = CreateArticleConstants.NAME_MAX_LENGTH_VALUE, message = CreateArticleConstants.NAME_MAX_LENGTH_MESSAGE)
    private String name;

    @NotBlank(message = CreateArticleConstants.DESCRIPTION_IS_MANDATORY)
    @NotNull(message = CreateArticleConstants.DESCRIPTION_IS_MANDATORY)
    @Size(max = CreateArticleConstants.DESCRIPTION_MAX_LENGTH_VALUE, message = CreateArticleConstants.DESCRIPTION_MAX_LENGTH_MESSAGE)
    private String description;

    @PositiveOrZero(message = CreateArticleConstants.QUANTITY_MUST_TO_BE_POSITIVE_OR_ZERO)
    private int quantity;

    @PositiveOrZero(message = CreateArticleConstants.QUANTITY_MUST_TO_BE_POSITIVE_OR_ZERO)
    private double price;

    @NotEmpty(message = CreateArticleConstants.CATEGORIES_MUST_NOT_BE_EMPTY)
    private List<CreateCategory> categories;

    @NotEmpty(message = CreateArticleConstants.BRAND_IS_MANDATORY)
    @NotNull(message = CreateArticleConstants.BRAND_IS_MANDATORY)
    private CreateBrand brand;
}
