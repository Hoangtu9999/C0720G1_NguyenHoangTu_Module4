package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "INTEGER")
    private String id;
    private String name;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "post_date", columnDefinition = "DATE")
    private String postDate;
    private String nameOfPost;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private CategoryEntity categoryEntity;


}
