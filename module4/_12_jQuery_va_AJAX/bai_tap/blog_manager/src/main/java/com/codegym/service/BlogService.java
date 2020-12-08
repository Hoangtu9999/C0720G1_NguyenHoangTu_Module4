package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    List<Blog> findAllById(Integer cat_id);

    Blog findById(Integer id);

    List<Blog> findAllByNameContaining(String name);

}
