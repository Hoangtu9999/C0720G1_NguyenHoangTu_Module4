package com.codegym.service;

import com.codegym.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();

    void save(CategoryEntity category);

    void edit(CategoryEntity category);

    CategoryEntity findById(String id);

    void delete(String id);
}
