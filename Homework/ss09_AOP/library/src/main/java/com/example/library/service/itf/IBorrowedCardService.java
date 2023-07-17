package com.example.library.service.itf;

import com.example.library.model.BorrowedCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IBorrowedCardService {
    boolean create(BorrowedCard borrowedCard);
    int showMaxId();
    Page<BorrowedCard> findAll(Pageable pageable);
    void minusOneBorrowedQuantity( int idBorrowedCard);
    String checkCodeCard(String code);

    boolean remove(int id);


}
