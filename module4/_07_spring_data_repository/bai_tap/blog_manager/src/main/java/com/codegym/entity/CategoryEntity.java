package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "INTEGER")
    private String Id;

    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    private List<BlogEntity> blogEntities;

    @Override
    public String toString() {
        return this.name;
    }
}
