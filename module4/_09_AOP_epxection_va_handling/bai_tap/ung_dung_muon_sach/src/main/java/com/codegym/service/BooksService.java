package com.codegym.service;

import com.codegym.entity.BooksEntity;

import java.util.List;

public interface BooksService {
    List<BooksEntity> findAll();

    BooksEntity findById(Integer id);

    void save(BooksEntity booksEntity);

    String borrow(Integer id) throws Exception;

    String giveBack(Integer loanNumber, Integer id);
}