package com.hoangtu.admin.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_type_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "product_type_name", columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> productList;


}
