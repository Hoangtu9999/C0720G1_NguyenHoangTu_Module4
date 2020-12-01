package com.codegym.service.impl;

import com.codegym.entity.BlogEntity;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogEntity> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<BlogEntity> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public void save(BlogEntity blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit( BlogEntity blog) {
        blogRepository.save(blog);
    }

    @Override
    public BlogEntity findById(String id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<BlogEntity> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<BlogEntity> findAllBlogAndSort() {
        return blogRepository.findAllBlogAndSort();
    }

    @Override
    public Page<BlogEntity> findByNameContaining(Pageable pageable, String keywordOld) {
        return blogRepository.findByNameContaining(pageable,keywordOld);
    }
}
