package com.example.library.service.itf;

import com.example.library.common.CodeCardException;
import com.example.library.model.DetailBorrowedCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDetailBorrowedCardService {
    boolean create(DetailBorrowedCard detailBorrowedCard);

    Page<DetailBorrowedCard> showByCode(Pageable pageable, String code) throws CodeCardException;

    boolean removeBorrowedCardBooks(int idBorrowedCard, int idBooks );

}
