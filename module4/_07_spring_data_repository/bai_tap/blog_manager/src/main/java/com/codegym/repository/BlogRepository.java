package com.codegym.repository;

import com.codegym.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogRepository extends JpaRepository<BlogEntity,String> {

    @Query(value = "select * from blog order by post_date desc",nativeQuery = true)
    List<BlogEntity> findAllBlogAndSort();

    Page<BlogEntity> findByNameContaining(Pageable pageable, String keywordOld);
}
