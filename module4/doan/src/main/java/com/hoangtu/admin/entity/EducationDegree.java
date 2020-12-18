package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "education_degree_name",columnDefinition = "VARCHAR(45)")
    private String name;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;
}
