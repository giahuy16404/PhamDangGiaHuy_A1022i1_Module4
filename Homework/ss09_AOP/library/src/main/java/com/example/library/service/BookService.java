package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.IBookRepository;
import com.example.library.service.itf.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Page<Book> listBooks(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public boolean createBook(Book book) {
        Book book1 = iBookRepository.save(book);
        return book1 != null;
    }

    @Override
    @Transactional
    public void minusOneBookQuantity(int idBook) {
        iBookRepository.minusOneBookQuantity(idBook);
    }

    @Override
    @Transactional
    public void increaseBookQuantity(int idBook) {
        iBookRepository.increaseBorrowedQuantity(idBook);
    }

    @Override
    public int checkQuantityBook(int idBook) {
        return iBookRepository.checkQuantityBook(idBook);
    }
}
