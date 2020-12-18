package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "oder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oder_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "oder_date_of_purchase",columnDefinition = "DATETIME")
    private String dateOfPurchase;

    @Column(name = "oder_status",columnDefinition = "BIT")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payments_id")
    private Payments payments;

    @OneToMany(mappedBy = "oder",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OderDetail> oderDetailList;


}
