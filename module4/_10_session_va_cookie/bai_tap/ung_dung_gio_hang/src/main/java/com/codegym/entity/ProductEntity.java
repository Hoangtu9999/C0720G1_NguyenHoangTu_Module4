package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String nameProduct;

    private Integer quantity;

    private Double price;

    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL)
    List<CartDetailEntity> cartDetailEntities;

}
