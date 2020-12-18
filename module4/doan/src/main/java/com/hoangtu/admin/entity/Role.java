package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", columnDefinition = "BIGINT")
    private String id;

    @Column(name = "role_name", columnDefinition = "VARCHAR(45)")
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UserRole> userRoleList;

    public Role(int i) {
    }
}
