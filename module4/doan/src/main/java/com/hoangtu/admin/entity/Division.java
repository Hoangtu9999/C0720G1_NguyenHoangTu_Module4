package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "division_name",columnDefinition = "VARCHAR(45)")
    private String name;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;
}
