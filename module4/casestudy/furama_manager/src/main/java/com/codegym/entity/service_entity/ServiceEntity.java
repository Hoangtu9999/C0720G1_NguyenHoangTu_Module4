package com.codegym.entity.service_entity;

import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @NotEmpty(message = "Vui lòng nhập tên dịch vụ")
    private String serviceName;

    @Min(value = 1, message = "Vui lòng nhập diện tích")
    private int serviceArea;

    @Min(value = 1, message = "Vui lòng nhập chi phí thuê")
    private double serviceCost;

    @Min(value = 1, message = "Vui lòng nhập số người tối đa")
    private int serviceMaxPeople;

    @NotEmpty(message = "Vui lòng nhập tiêu chuẩn phòng")
    private String standardRoom;

    private String descriptionOtherConvenience;

    @Min(value = 1, message = "Vui lòng nhập diện tích hồ bơi")
    private double poolArea;

    @Min(value = 1, message = "Vui lòng nhập số tầng")
    private int numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "serviceEntity", cascade = CascadeType.ALL)
    List<Contract> listContract;

    @Override
    public String toString() {
        return serviceName + serviceArea + serviceCost + serviceMaxPeople + standardRoom + descriptionOtherConvenience + poolArea + numberOfFloors;
    }
    public String getCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "DV-" + numberFormat.format(this.serviceId);
    }
}
