package com.bootcamp.pragma.stockmicroservice.domain.usecase.util;

import com.bootcamp.pragma.stockmicroservice.application.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;

import java.util.ArrayList;
import java.util.List;

public class CategoryTestUtil {
    private CategoryTestUtil() {}

    public static Category generateCategoy(){
        return new Category(1L, "Comida", "Pa' comer");
    }

    public static List<Category> generateCategories(){
        return List.of(
                new Category(1L, "Comida", "Pa' comer"),
                new Category(2L, "Electrodomestico", "Cosas electricas")
        );
    }

    public static ContentPage<Category> generateContentPageCategory(){
        return new ContentPage<Category>(
                1,
                2,
                0,
                10,
                true,
                true,
                generateCategories()
        );
    }
    public static ContentPage<Category> generateEmptyContentPageCategory(){
        return new ContentPage<Category>(
                0,
                0,
                0,
                0,
                true,
                true,
                new ArrayList<>()
        );
    }

    public static ContentPage<CategoryResponse> generateEmptyContentPageCategoryResponse(){
        return new ContentPage<CategoryResponse>(
                0,
                0,
                0,
                0,
                true,
                true,
                new ArrayList<>()
        );
    }

    public static List<Category> generateMoreThanThreeCategories(){
        return List.of(
                new Category(1L, "Comida", "Pa' comer"),
                new Category(2L, "Electrodomestico", "Cosas electricas"),
                new Category(3L, "Aseo", "Para lavar"),
                new Category(4L, "Tecnologia", "Ocio")
        );
    }
}
