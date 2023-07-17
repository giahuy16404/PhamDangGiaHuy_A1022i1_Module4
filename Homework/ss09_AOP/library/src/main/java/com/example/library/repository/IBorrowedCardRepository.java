package com.example.library.repository;

import com.example.library.model.BorrowedCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBorrowedCardRepository extends JpaRepository<BorrowedCard,Integer> {
    @Query(value = QueryDb.SHOW_MAX_ID_BORROWED,nativeQuery = true)
    int showMaxId();

    @Query(value = QueryDb.BORROWED_QUANTITY_MINUS_ONE,nativeQuery = true)
    @Modifying
    void minusOneBorrowedQuantity(@Param("idBorrowed") int idBorrowedCard);

    @Query(value = QueryDb.CHECK_CODE_CARD,nativeQuery = true)
    String checkCodeCard(@Param("code")String code);



}
