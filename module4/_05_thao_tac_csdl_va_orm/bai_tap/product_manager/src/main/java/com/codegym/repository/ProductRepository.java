package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void edit(Integer id,Product product);

    void delete(Integer id);
}
