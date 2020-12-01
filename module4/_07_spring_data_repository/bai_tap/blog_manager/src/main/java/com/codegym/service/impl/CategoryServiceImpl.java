package com.codegym.service.impl;

import com.codegym.entity.CategoryEntity;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
    @Override
    public void save(CategoryEntity category) {
        repository.save(category);
    }

    @Override
    public void edit( CategoryEntity category) {
        repository.save(category);
    }

    @Override
    public CategoryEntity findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
