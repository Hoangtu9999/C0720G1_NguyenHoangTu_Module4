package com.codegym.entity.contract;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service_entity.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "contract")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE")
    @NotBlank(message = "vui lòng nhập ngày làm hợp đồng")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    @NotBlank(message = "vui lòng nhập ngày kết thúc hợp đồng")
    private String contractEndDate;

    @Min(value = 1, message = "Vui lòng nhập số tiền đặt cọc")
    private double contractDeposit;

    @Min(value = 1, message = "Vui lòng nhập tổng số tiền")
    private double contractTotalMoney;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    List<ContractDetail> listContractDetail;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private ServiceEntity serviceEntity;

    @Override
    public String toString() {
        return contractStartDate + contractEndDate + contractDeposit + contractTotalMoney;
    }
}
