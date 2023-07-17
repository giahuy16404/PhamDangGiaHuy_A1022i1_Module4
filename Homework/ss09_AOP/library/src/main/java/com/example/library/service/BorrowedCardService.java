package com.example.library.service;

import com.example.library.model.BorrowedCard;
import com.example.library.repository.IBorrowedCardRepository;
import com.example.library.service.itf.IBorrowedCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BorrowedCardService implements IBorrowedCardService {
    @Autowired
    private IBorrowedCardRepository iBorrowedCardRepository;

    @Override
    public boolean create(BorrowedCard borrowedCard) {
        BorrowedCard borrowedCard1 = iBorrowedCardRepository.save(borrowedCard);
        return borrowedCard1 != null;
    }

    @Override
    public int showMaxId() {
        return iBorrowedCardRepository.showMaxId();
    }

    @Override
    public Page<BorrowedCard> findAll(Pageable pageable) {
        return iBorrowedCardRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void minusOneBorrowedQuantity(int idBorrowedCard) {
        iBorrowedCardRepository.minusOneBorrowedQuantity(idBorrowedCard);
    }

    @Override
    public String checkCodeCard(String code) {
        return iBorrowedCardRepository.checkCodeCard(code);
    }

    @Override
    @Transactional
    public boolean remove(int id) {
        try {
            iBorrowedCardRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
