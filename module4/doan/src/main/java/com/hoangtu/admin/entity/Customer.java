package com.hoangtu.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Validator {

//    @Autowired
//    private CustomerService customerService;

    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.hoangtu.admin.entity.generator.MyGenerator")
    @Column(name = "customer_id",columnDefinition = "VARCHAR(45)")
    private String id;

    @Column(name = "customer_name",columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "please input name")
    private String name;

    @Column(name = "customer_birthday",columnDefinition = "DATE")
    private String birthday;

    @Column(name = "customer_gender",columnDefinition = "BIT")
    private Boolean gender;

    @Column(name = "customer_id_card",columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "please input id card")
//    @Size
//    @Min
//    @Max
//    @Pattern(regexp = "^\\d{9}| \\{12}$")
    private String idCard;

    @Column(name = "customer_email",columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "please input email")
//    @EmailCustomer
    private String email;

    @Column(name = "customer_number_phone",columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "please input number phone")
//    @Pattern(regexp = "^(09|\\(84\\)+9)[0,1]\\d{7}$")
    private String numberPhone;

    @Column(name = "customer_address",columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "please input address")
    private String address;

    @Column(name = "status_delete", columnDefinition = "BIT")
    private boolean status = true;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Oder> oderList;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Evaluate> evaluateList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalDate dateOfBirth = LocalDate.parse(birthday);
        Customer customer = (Customer) target;

        if (!Pattern.compile("^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$").matcher(customer.email).find()){
            errors.rejectValue("email","email.regex");
        }

        if (!Pattern.compile("^(09|\\(84\\)+9)[0,1]\\d{7}$").matcher(customer.numberPhone).find()){
            errors.rejectValue("numberPhone","numberPhone.regex");
        }
        if (LocalDate.now().getYear() - dateOfBirth.getYear() < 18) {
            errors.rejectValue("birthday", "dateOfBirth.regex");
        }

//        if(this.customerService.findByEmail(customer.getEmail()) != null){
//            errors.rejectValue("email","email.checkExists");
//        }

//        LocalDate startDate = LocalDate.parse(contract.getStartDate());
//        LocalDate endDate = LocalDate.parse(contract.getEndDate());
//        if (endDate.compareTo(startDate) <= 0) {
//            errors.rejectValue("endDate","contract.endDate.error");
//        }
    }
}
