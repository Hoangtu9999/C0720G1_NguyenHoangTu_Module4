package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void edit(Integer id,Product product);

    void delete(Integer id);
}
