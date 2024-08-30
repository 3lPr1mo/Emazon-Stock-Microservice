package com.bootcamp.pragma.stockmicroservice.domain.model;

import java.util.List;

public class Article {
    private Long id;
    private Integer quantity;
    private Double price;
    private List<Category> categories;
    private Brand brand;

    public Article(Long id, Integer quantity, Double price, List<Category> categories, Brand brand) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
