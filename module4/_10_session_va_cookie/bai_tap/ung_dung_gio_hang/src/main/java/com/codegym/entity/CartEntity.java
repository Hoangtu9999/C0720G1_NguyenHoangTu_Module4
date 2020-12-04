package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
        
    private double totalMoney;

    @OneToMany(mappedBy = "cartEntity",cascade = CascadeType.ALL)
    private List<CartDetailEntity> cartDetailEntities;
}
