package com.codegym.entity.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String username;

    private String password;

    @ManyToMany(mappedBy = "listUser")
    @JsonManagedReference
    private List<Role> listRole;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Employee> listEmployee;
}
