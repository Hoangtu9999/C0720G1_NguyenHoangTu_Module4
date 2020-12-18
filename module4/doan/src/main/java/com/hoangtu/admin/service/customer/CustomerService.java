package com.hoangtu.admin.service.customer;

import com.hoangtu.admin.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(String id);

    void delete(String id);

    Page<Customer> findByNameContainingOrEmailContaining(String keywordAfterCheck1,String keywordAfterCheck2, Pageable pageable);

    Page<Customer> findByDateStartAndDateEnd(String dateStart, String dateEnd,Pageable pageable);

    Page<Customer> searchByName(String keywordAfterCheck1, Pageable pageable);

    Page<Customer> searchByAddress(String keywordAfterCheck1, Pageable pageable);

    Page<Customer> findAllByNameOrAddress(Optional<String> keyword, Pageable pageable);

//    Customer findByEmail(String email);


}
