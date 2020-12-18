package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "position")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "position_name",columnDefinition = "VARCHAR(45)")
    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;
}
