package com.sky.model;

import java.util.List;

public class ProductCatalogue {

    private String category;
    private List<Product> products;

    public ProductCatalogue(String category, List<Product> products) {
        this.category = category;
        this.products = products;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
