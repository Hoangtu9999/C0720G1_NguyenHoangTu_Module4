package com.codegym.tao_ung_dung_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "INTEGER")
    private String id;
    private String name;
    private String title;
    private String content;
    @Column(name = "post_date", columnDefinition = "DATE")
    private String postDate;
    private String nameOfPost;

}
