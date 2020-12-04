package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartDetailId;

    private Integer quantity;

    private double totalMoney;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CartEntity cartEntity;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
