package com.service.itf;

import com.model.Borrowing;

import java.util.List;

public interface IBorrowingService {
    boolean add(Borrowing borrowing);
    List<Borrowing> findAll();

}
