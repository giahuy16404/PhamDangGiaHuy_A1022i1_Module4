package com.example.thi.service;

import com.example.thi.model.DoanhNghiep;
import com.example.thi.model.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDuAnService {
    List<DoanhNghiep> findDoanhNghiep();
    DuAn addDuAn(DuAn duAn);
    Page<DuAn> findPageAndSearch(Pageable pageable, @Param("valueSearch") String valueSearch );
     DuAn findById(Long id);

}
