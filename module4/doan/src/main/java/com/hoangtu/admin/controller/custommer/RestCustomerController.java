package com.hoangtu.admin.controller.custommer;

import com.hoangtu.admin.entity.Customer;
import com.hoangtu.admin.entity.Product;
import com.hoangtu.admin.service.customer.CustomerService;
import com.hoangtu.admin.service.producer.ProducerService;
import com.hoangtu.admin.service.product.ProductService;
import com.hoangtu.admin.service.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/modal-edit/{id}")
    public ResponseEntity<Customer> getProductEdit(@PathVariable String id) {
        Customer customer = this.customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//    @PostMapping("/search/{dateStart}/{dateEnd}")
//    public ResponseEntity<List<Customer>> search(@PathVariable LocalDate dateStart , @PathVariable LocalDate dateEnd ){
//        List<Customer> customerList = this.customerService.findByDateStartAndDateEnd(dateStart,dateEnd);
//    }



}
