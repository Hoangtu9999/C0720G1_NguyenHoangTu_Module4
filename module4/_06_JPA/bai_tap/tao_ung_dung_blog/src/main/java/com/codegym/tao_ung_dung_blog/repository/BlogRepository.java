package com.codegym.tao_ung_dung_blog.repository;

import com.codegym.tao_ung_dung_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,String> {


}
