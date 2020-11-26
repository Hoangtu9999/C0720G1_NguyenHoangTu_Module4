package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private String productType;
    private double price;

    public Product(Integer id, String name, String productType, double price) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
