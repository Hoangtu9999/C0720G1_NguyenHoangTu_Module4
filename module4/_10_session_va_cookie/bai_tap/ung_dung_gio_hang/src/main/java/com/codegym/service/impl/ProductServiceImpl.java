package com.codegym.service.impl;

import com.codegym.entity.ProductEntity;
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
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductEntity productEntity) {
        repository.save(productEntity);
    }
}
