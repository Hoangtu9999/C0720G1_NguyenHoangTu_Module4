package com.codegym.service.impl;

import com.codegym.entity.BookLoanCardEntity;
import com.codegym.entity.BooksEntity;
import com.codegym.repository.BookLoanCardRepository;
import com.codegym.repository.BooksRepository;
import com.codegym.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BookLoanCardRepository bookLoanCardRepository;

    @Override
    public List<BooksEntity> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public BooksEntity findById(Integer id) {
        return this.booksRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BooksEntity booksEntity) {
        this.booksRepository.save(booksEntity);
    }

    @Override
    public String borrow(Integer id) throws Exception {
        BooksEntity booksEntity = findById(id);
        if (booksEntity.getQuantity() == 0) {
            throw new Exception("Hết sách rồi ba !");
        } else {
            booksEntity.setQuantity(booksEntity.getQuantity() - 1);
            BookLoanCardEntity bookLoanCardEntity = new BookLoanCardEntity();
            bookLoanCardEntity.setId((int) (Math.random() * 100));
            bookLoanCardEntity.setLoanNumber((int) ((Math.random() * 9999) + 1000));

            bookLoanCardRepository.save(bookLoanCardEntity);
            return String.valueOf(bookLoanCardEntity.getLoanNumber());
        }
    }

    @Override
    public String giveBack(Integer loanNumber, Integer id) {
        List<BookLoanCardEntity> bookLoanCardEntityList = this.bookLoanCardRepository.findAll();
        boolean check = false;
        for (BookLoanCardEntity bookLoanCardEntity : bookLoanCardEntityList) {
            if (bookLoanCardEntity.getLoanNumber().equals(loanNumber)) {
                check = true;
                BooksEntity book = findById(id);
                book.setQuantity(book.getQuantity() + 1);
                this.bookLoanCardRepository.delete(bookLoanCardEntity);
                break;
            }
        }
        if (check) {
            return "Give Back Complete !";
        } else {
            return "Book Loan Number is not exist !";
        }
    }
}