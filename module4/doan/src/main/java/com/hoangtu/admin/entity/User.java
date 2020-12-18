package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "username", columnDefinition = "VARCHAR(255)")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "email",columnDefinition = "VARCHAR(45)")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Customer> customerList;

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
   @JsonBackReference
   private List<UserRole> userRoleList;

    @OneToMany(mappedBy = "user")
    private List<Employee> employeeList;
}
