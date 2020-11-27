package com.codegym.service.impl;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void edit(Integer id,Product product) {
        repository.edit(id,product);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
