package com.hoangtu.admin.repository;

import com.hoangtu.admin.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
}
