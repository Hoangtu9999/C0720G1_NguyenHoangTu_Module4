package com.hoangtu.admin.service.product.impl;

import com.hoangtu.admin.entity.Product;
import com.hoangtu.admin.repository.ProductRepository;
import com.hoangtu.admin.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void save(Product product) {
        this.repository.save(product);
    }


    @Override
    public Product findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
         this.repository.deleteById(id);
    }
}
