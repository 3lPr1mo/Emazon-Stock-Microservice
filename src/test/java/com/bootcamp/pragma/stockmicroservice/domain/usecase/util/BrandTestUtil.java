package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

import java.util.ArrayList;
import java.util.List;

public class BrandTestUtil {
    private BrandTestUtil() {}

    public static Brand generateBrand() {
        return new Brand(1L, "Apple", "Pc's");
    }

    public static List<Brand> generateBrands() {
        return List.of(
                new Brand(1L, "Apple", "Pc's"),
                new Brand(2L, "Microsoft", "Lo mismo de apple pero mas barato")
        );
    }

    public static ContentPage<Brand> generateBrandPage() {
        return new ContentPage<>(
                1,
                2,
                0,
                10,
                true,
                true,
                generateBrands()
        );
    }

    public static ContentPage<Brand> generateEmptyContentPageBrand(){
        return new ContentPage<Brand>(
                0,
                0,
                0,
                0,
                true,
                true,
                new ArrayList<>()
        );
    }
}
