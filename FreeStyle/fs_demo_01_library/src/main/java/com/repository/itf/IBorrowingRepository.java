package com.repository.itf;

import com.model.Borrowing;

import java.util.List;

public interface IBorrowingRepository {
    boolean add(Borrowing borrowing);
    List<Borrowing> findAll();
}
