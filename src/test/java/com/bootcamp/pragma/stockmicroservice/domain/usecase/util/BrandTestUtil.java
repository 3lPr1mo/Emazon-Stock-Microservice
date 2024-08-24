package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;

public class BrandTestUtil {
    private BrandTestUtil() {}

    public static Brand generateBrand() {
        return new Brand(1L, "Apple", "Pc's");
    }
}
