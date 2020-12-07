package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> blogList = blogService.findAll();

        if (blogList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-category/{cat_id}")
    public ResponseEntity<List<Blog>> getAllCategory(@PathVariable Integer cat_id) {
        List<Blog> blogList = this.blogService.findAllById(cat_id);

        if (blogList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getDetailBlog(@PathVariable Integer id) {
        Blog blog = this.blogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
