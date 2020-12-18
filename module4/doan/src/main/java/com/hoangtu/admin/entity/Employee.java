package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",columnDefinition = "BIGINT")
    private String id;

    @Column(name = "employee_name", columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(name = "employee_birthday",columnDefinition = "DATE")
    private String birthday;

    @Column(name = "employee_id_card",columnDefinition = "VARCHAR(45)")
    private String idCard;

    @Column(name = "employee_salary",columnDefinition = "DECIMAL(18,0)")
    private String salary;

    @Column(name = "employee_number_phone",columnDefinition = "VARCHAR(45)")
    private String numberPhone;

    @Column(name = "employee_email",columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(name = "employee_address",columnDefinition = "VARCHAR(45)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Receipt> receiptList;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;



}
