package com.bootcamp.pragma.stockmicroservice.application.dto.request;

import com.bootcamp.pragma.stockmicroservice.application.util.ArticleDtoConstants;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateStockArticleRequest {
    @Positive(message = ArticleDtoConstants.ARTICLE_ID_IS_MANDATORY)
    private Long articleId;
    @Positive(message = ArticleDtoConstants.ARTICLE_QUANTITY_MUST_BE_POSITIVE)
    private Integer quantity;
}
