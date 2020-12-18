package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "producer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producer_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "producer_name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "producer_address", columnDefinition = "VARCHAR(255)")
    private String address;

    @Column(name = "producer_email", columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(name = "producer_number_phone", columnDefinition = "VARCHAR(45)")
    private String numberPhone;

    @OneToMany(mappedBy = "producer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> productList;
}
