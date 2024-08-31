package com.bootcamp.pragma.stockmicroservice.application.dto.request;

import com.bootcamp.pragma.stockmicroservice.application.util.CreateBrandConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateBrand {
    @NotNull(message = CreateBrandConstants.NAME_IS_MANDATORY)
    @NotBlank(message = CreateBrandConstants.NAME_IS_MANDATORY)
    @Size(max = CreateBrandConstants.NAME_MAX_LENGTH_VALUE, message = CreateBrandConstants.NAME_MAX_LENGTH_MESSAGE)
    private String name;

    @NotNull(message = CreateBrandConstants.DESCRIPTION_IS_MANDATORY)
    @NotBlank(message = CreateBrandConstants.DESCRIPTION_IS_MANDATORY)
    @Size(max = CreateBrandConstants.DESCRIPTION_MAX_LENGTH_VALUE, message = CreateBrandConstants.DESCRIPTION_MAX_LENGTH_MESSAGE)
    private String description;
}
