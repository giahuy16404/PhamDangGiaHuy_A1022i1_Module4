package com.example.library.service;

import com.example.library.common.CodeCardException;
import com.example.library.model.DetailBorrowedCard;
import com.example.library.repository.IDetailBorrowedCardRepository;
import com.example.library.service.itf.IDetailBorrowedCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetailBorrowedCardService implements IDetailBorrowedCardService {
    @Autowired
    private IDetailBorrowedCardRepository iDetailBorrowedCardRepository;

    @Override
    public boolean create(DetailBorrowedCard detailBorrowedCard) {
        DetailBorrowedCard detailBorrowedCard1 = iDetailBorrowedCardRepository.save(detailBorrowedCard);
        return detailBorrowedCard1 != null;
    }

    @Override
    public Page<DetailBorrowedCard> showByCode(Pageable pageable, String code) throws CodeCardException {
        if (iDetailBorrowedCardRepository.showByCode(pageable, code).isEmpty()){
            throw new CodeCardException("Code không có trong hệ thống!");
        }
        return iDetailBorrowedCardRepository.showByCode(pageable, code);
    }

    @Override
    public boolean removeBorrowedCardBooks(int idBorrowedCard, int idBooks) {
        try {
            iDetailBorrowedCardRepository.removeBorrowedCardBooks(idBorrowedCard, idBooks);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
