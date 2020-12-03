package com.codegym.repository;

import com.codegym.entity.BookLoanCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanCardRepository extends JpaRepository<BookLoanCardEntity, Integer> {
}