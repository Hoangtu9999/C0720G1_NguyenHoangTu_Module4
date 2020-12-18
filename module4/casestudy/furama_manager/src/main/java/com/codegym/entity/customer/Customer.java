package com.codegym.entity.customer;

import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotEmpty(message = "Vui lòng nhập tên")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    @NotBlank(message = "vui lòng nhập ngày sinh")
    private String customerBirthday;

    private Integer customerGender;

    @Pattern(regexp = "\\d{9}" ,message = "Vui lòng nhập số CMND phải đúng định dạng XXXXXXXXX")
    private String customerIdCard;

    @Pattern(regexp = "(^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$)",message = "Vui lòng nhập số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message = "Vui lòng nhập địa chỉ email phải đúng định dạng email abc@gmail.com")
    private String customerEmail;

    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Contract> listContract;

    @Override
    public String toString() {
        return customerName + customerBirthday + customerGender + customerIdCard + customerPhone + customerEmail + customerAddress;
    }
    public String getCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "KH-" + numberFormat.format(this.customerId);
    }
}
