package com.hoangtu.admin.repository;

import com.hoangtu.admin.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
