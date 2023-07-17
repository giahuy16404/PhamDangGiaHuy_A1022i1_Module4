package com.example.library.service.itf;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBookService {
    Page<Book> listBooks(Pageable pageable);

    boolean createBook(Book book);
    void minusOneBookQuantity( int idBook);
    void increaseBookQuantity( int idBook);
    int checkQuantityBook(int idBook);


}
