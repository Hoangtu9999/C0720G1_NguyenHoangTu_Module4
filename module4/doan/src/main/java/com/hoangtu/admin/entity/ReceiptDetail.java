package com.hoangtu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "receipt_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_detail_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "receipt_detail_import_quantity",columnDefinition = "INTEGER")
    private String importQuantity;

    @Column(name = "receipt_detail_import_price",columnDefinition = "DECIMAL(18,0)")
    private String importPrice;

    @Column(name = "receipt_detail_import_unit",columnDefinition = "VARCHAR(45)")
    private String importUnit;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "recepit_id")
    private Receipt receipt;


}
