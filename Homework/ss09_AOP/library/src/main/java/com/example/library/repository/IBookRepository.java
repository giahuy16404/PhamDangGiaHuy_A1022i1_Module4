package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = QueryDb.BORROWED_BOOK_MINUS_ONE,nativeQuery = true)
    @Modifying
    void minusOneBookQuantity(@Param("idBook") int idBook);

    @Query(value = QueryDb.BORROWED_BOOK_INCREASE,nativeQuery = true)
    @Modifying
    void increaseBorrowedQuantity(@Param("idBook") int idBorrowedCard);

    @Query(value = QueryDb.CHECK_QUANTITY_BOOK,nativeQuery = true)
    int checkQuantityBook(@Param("idBook")int idBook);

}
