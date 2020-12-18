package com.hoangtu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "promotion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "promotion_form",columnDefinition = "VARCHAR(45)")
    private String form;

    @Column(name = "promotion_ratio", columnDefinition = "VARCHAR(45)")
    private String ratio;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
