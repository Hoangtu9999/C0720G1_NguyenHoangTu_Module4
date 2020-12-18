package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payments_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "payments_name", columnDefinition = "VARCHAR(45)")
    private String name;

    @OneToMany(mappedBy = "payments", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Oder> oderList;
}
