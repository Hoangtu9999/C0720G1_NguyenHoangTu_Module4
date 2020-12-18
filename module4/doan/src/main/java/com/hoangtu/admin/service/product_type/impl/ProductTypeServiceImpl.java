package com.hoangtu.admin.service.product_type.impl;

import com.hoangtu.admin.entity.ProductType;
import com.hoangtu.admin.repository.ProductTypeRepository;
import com.hoangtu.admin.service.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository repository;

    @Override
    public List<ProductType> findAll() {

       return this.repository.findAll();
    }
}
