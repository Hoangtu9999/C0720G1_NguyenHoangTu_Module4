package com.codegym.entity.employee;

import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotEmpty(message = "Vui lòng nhập tên")
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @NotBlank(message = "vui lòng nhập ngày sinh")
    private String employeeBirthday;

    @Pattern(regexp = "\\d{9}", message = "Vui lòng nhập số CMND phải đúng định dạng XXXXXXXXX")
    private String employeeIdCard;

    @Min(value = 100,message = "Lương không dưới 100$")
    private double employeeSalary;

    @Pattern(regexp = "(^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$)", message = "Vui lòng nhập số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String employeePhone;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Vui lòng nhập địa chỉ email phải đúng định dạng email abc@gmail.com")
    private String employeeEmail;

    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> listContract;


}
