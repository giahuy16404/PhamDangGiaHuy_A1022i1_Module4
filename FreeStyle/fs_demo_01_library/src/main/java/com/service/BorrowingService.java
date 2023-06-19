package com.service;

import com.model.Borrowing;
import com.repository.ConnectDB;
import com.repository.QueryDB;
import com.repository.itf.IBorrowingRepository;
import com.service.itf.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BorrowingService implements IBorrowingService {
    @Autowired
    IBorrowingRepository iBorrowingRepository;
    @Override
    public boolean add(Borrowing borrowing) {
        if (iBorrowingRepository.add(borrowing)){
            return true;
        }
        return false;
    }

    @Override
    public List<Borrowing> findAll() {
        return iBorrowingRepository.findAll();
    }
}
