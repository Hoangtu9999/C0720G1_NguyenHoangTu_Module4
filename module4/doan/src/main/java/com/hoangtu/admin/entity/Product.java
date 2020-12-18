package com.hoangtu.admin.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.hoangtu.admin.entity.generator.MyGenerator")


    @Column(name = "product_id", columnDefinition = "VARCHAR(45)")
    private String id;

    @Column(name = "product_name", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Please input name product!")
    private String name;

    @Column(name = "product_picture", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Please input picture!")
    private String picture;

    @Column(name = "product_warranty_period", columnDefinition = "INTEGER")
    @NotBlank(message = "Please input warranty period!")
    private String warrantyPeriod;

    @Column(name = "product_quantity", columnDefinition = "INTEGER")
    @NotBlank(message = "Please input quantity!")
    private String quantity;

    @Column(name = "product_unit", columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "Please input unit!")
    private String unit;

    @Column(name = "product_price", columnDefinition = "Decimal(18,0)")
    @NotBlank(message = "Please input retail price!")
    private String retailPrice;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Promotion> promotionList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Evaluate> evaluateList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OderDetail> oderDetailList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReceiptDetail> receiptDetailList;

    @Override
    public String toString() {
        return name ;

    }

}
