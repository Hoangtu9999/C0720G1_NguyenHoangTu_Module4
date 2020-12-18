package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "receipt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "receipt_date_added",columnDefinition = "DATETIME")
    private String dateAdded;

    @Column(name = "receipt_note",columnDefinition = "VARCHAR(255)")
    private String note;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReceiptDetail> receiptDetailList;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
