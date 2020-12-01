package com.codegym.reposiory;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public class CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province provice);
}
