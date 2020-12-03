package com.codegym.service;
import com.codegym.entity.BookLoanCardEntity;

import java.util.List;

public interface BookLoanCardService {
    List<BookLoanCardEntity> findAll();

    void save(BookLoanCardEntity bookLoanCardEntity);
}