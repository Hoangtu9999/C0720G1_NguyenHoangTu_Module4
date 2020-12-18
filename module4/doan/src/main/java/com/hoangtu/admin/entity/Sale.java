package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "sale_name",columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "sale_start_day",columnDefinition = "DATETIME")
    private String startDay;

    @Column(name = "sale_end_day",columnDefinition = "DATETIME")
    private String endDay;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Promotion> promotionList;


}
