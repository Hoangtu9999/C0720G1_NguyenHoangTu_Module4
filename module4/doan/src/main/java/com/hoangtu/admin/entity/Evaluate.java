package com.hoangtu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "evaluate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluate_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "evaluate_content",columnDefinition = "VARCHAR(255)")
    private String content;

    @Column(name = "evaluate_number_of_stars",columnDefinition = "INTEGER")
    private String numberOfStars;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
