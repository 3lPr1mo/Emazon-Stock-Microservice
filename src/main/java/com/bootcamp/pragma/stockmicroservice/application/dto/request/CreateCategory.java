package com.bootcamp.pragma.stockmicroservice.application.dto.request;

import com.bootcamp.pragma.stockmicroservice.application.util.CreateCategoryConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCategory {
    @NotBlank(message = CreateCategoryConstants.NAME_IS_MANDATORY)
    @NotNull(message = CreateCategoryConstants.NAME_IS_MANDATORY)
    @Size(max = CreateCategoryConstants.NAME_MAX_LENGTH_VALUE, message = CreateCategoryConstants.NAME_MAX_LENGHT)
    private final String name;

    @NotBlank(message = CreateCategoryConstants.DESCRIPTION_IS_MANDATORY)
    @NotNull(message = CreateCategoryConstants.DESCRIPTION_IS_MANDATORY)
    @Size(max = CreateCategoryConstants.DESCRIPTION_MAX_LENGTH_VALUE, message = CreateCategoryConstants.DESCRIPTION_MAX_LENGTH)
    private final String description;
}
