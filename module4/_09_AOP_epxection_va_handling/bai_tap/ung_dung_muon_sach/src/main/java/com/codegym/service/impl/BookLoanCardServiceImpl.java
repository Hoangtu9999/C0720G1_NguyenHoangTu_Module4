package com.codegym.service.impl;

import com.codegym.entity.BookLoanCardEntity;
import com.codegym.repository.BookLoanCardRepository;
import com.codegym.service.BookLoanCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanCardServiceImpl implements BookLoanCardService {
    @Autowired
    private BookLoanCardRepository bookLoanCardRepository;

    @Override
    public List<BookLoanCardEntity> findAll() {
        return this.bookLoanCardRepository.findAll();
    }

    @Override
    public void save(BookLoanCardEntity bookLoanCardEntity) {
        this.bookLoanCardRepository.save(bookLoanCardEntity);
    }
}
