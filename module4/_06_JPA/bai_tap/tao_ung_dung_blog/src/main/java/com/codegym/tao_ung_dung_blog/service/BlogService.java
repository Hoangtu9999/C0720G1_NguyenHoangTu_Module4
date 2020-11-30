package com.codegym.tao_ung_dung_blog.service;

import com.codegym.tao_ung_dung_blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void edit(Blog blog);

    Blog findById(String id);

    void delete(String id);
}
