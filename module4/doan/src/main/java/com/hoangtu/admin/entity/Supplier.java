package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "supplier_name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "supplier_address", columnDefinition = "VARCHAR(255)")
    private String address;

    @Column(name = "supplier_email", columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(name = "supplier_number_phone", columnDefinition = "VARCHAR(45)")
    private String numberPhone;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Receipt> receiptList;
}
