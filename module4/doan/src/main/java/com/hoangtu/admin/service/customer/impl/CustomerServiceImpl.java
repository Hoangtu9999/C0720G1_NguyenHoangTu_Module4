package com.hoangtu.admin.service.customer.impl;

import com.hoangtu.admin.entity.Customer;
import com.hoangtu.admin.entity.Product;
import com.hoangtu.admin.repository.CustomerRepository;
import com.hoangtu.admin.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.repository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<Customer> findByNameContainingOrEmailContaining(String keywordAfterCheck1,String keywordAfterCheck2, Pageable pageable) {
        return repository.findByNameContainingOrEmailContaining(keywordAfterCheck1,keywordAfterCheck2,pageable);
    }

    @Override
    public Page<Customer> findByDateStartAndDateEnd(String dateStart, String dateEnd,Pageable pageable) {
        return this.repository.findAllByBirthdayBetween(dateStart,dateEnd,pageable);
    }

    @Override
    public Page<Customer> searchByName(String keywordAfterCheck1, Pageable pageable) {
        return this.repository.findAllByNameContaining(keywordAfterCheck1,pageable);
    }

    @Override
    public Page<Customer> searchByAddress(String keywordAfterCheck1, Pageable pageable) {
        return this.repository.findAllByAddressContaining(keywordAfterCheck1, pageable);
    }

    @Override
    public Page<Customer> findAllByNameOrAddress(Optional<String> keyword, Pageable pageable) {
        return this.repository.findAllByNameContainingOrAddressContaining(keyword,pageable);
    }

//    @Override
//    public Customer findByEmail(String email) {
//        return this.repository.findByEmail(email);
//    }
}
