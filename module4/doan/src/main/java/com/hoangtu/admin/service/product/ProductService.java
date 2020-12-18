package com.hoangtu.admin.service.product;

import com.hoangtu.admin.entity.Product;

import java.util.List;

public interface ProductService{

    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    void delete(String id);
}
