package com.codegym.tao_ung_dung_blog.service.impl;

import com.codegym.tao_ung_dung_blog.entity.Blog;
import com.codegym.tao_ung_dung_blog.repository.BlogRepository;
import com.codegym.tao_ung_dung_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit( Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(String id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        blogRepository.deleteById(id);
    }
}
