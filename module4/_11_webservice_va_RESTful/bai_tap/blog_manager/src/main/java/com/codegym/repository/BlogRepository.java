package com.codegym.repository;

import com.codegym.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value ="select * from Blog where category_id = ?", nativeQuery = true)
    List<Blog> findAllById(Integer cat_id);
}
