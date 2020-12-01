package com.codegym.service;

import com.codegym.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface BlogService {
    List<BlogEntity> findAll();

    Page<BlogEntity> findAll(Pageable pageable);

    void save(BlogEntity blog);

    void edit(BlogEntity blog);

    BlogEntity findById(String id);

    void delete(String id);

    Page<BlogEntity> findPaginated(int pageNo,int pageSize);

    List<BlogEntity> findAllBlogAndSort();

    Page<BlogEntity> findByNameContaining(Pageable pageable, String keywordOld);
}
