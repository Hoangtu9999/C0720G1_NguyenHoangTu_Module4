package com.hoangtu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "oder_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oder_detail_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "oder_detail_quantity",columnDefinition = "INTEGER")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Oder oder;
}
