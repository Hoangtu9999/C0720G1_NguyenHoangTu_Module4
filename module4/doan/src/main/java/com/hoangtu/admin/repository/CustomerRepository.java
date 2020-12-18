package com.hoangtu.admin.repository;

import com.hoangtu.admin.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {


    Page<Customer> findByNameContainingOrEmailContaining(String keywordAfterCheck1,String keywordAfterCheck2, Pageable pageable);


    Page<Customer> findAllByBirthdayBetween(String dateStart , String dateEnd,Pageable pageable);

    Page<Customer> findAllByNameContaining(String keywordAfterCheck1, Pageable pageable);

    Page<Customer> findAllByAddressContaining(String keywordAfterCheck1, Pageable pageable);

    Page<Customer> findAllByNameContainingOrAddressContaining(Optional<String> keyword, Pageable pageable);

//    Customer findByEmail(String email);
}
