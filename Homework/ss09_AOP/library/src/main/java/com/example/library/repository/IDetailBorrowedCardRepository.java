package com.example.library.repository;

import com.example.library.model.BorrowedCard;
import com.example.library.model.DetailBorrowedCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IDetailBorrowedCardRepository extends JpaRepository<DetailBorrowedCard,Integer> {
    @Query(value = QueryDb.SHOW_BY_CODE_DETAIL_CARD,nativeQuery = true)
    Page<DetailBorrowedCard> showByCode(Pageable pageable, @Param("code") String code);

    @Query(value = QueryDb.REMOVE_BORROWED_BOOKS,nativeQuery = true)
    @Modifying
    void removeBorrowedCardBooks(@Param("borrowedCard") int idBorrowedCard,@Param("idBooks") int idBooks );
}
