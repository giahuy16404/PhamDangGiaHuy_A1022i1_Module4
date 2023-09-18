package com.example.thi.service;

import com.example.thi.model.DoanhNghiep;
import com.example.thi.model.DuAn;
import com.example.thi.repository.IDoanhNghiepRepository;
import com.example.thi.repository.IDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DuAnService implements IDuAnService{
    @Autowired
    private IDoanhNghiepRepository iDoanhNghiepRepository;
    @Autowired
    private IDuAnRepository iDuAnRepository;
    @Override
    public List<DoanhNghiep> findDoanhNghiep() {
        return iDoanhNghiepRepository.findAll();
    }

    @Override
    public DuAn addDuAn(DuAn duAn) {
        return iDuAnRepository.save(duAn);
    }

    @Override
    public Page<DuAn> findPageAndSearch(Pageable pageable, String valueSearch) {
        return iDuAnRepository.findPageAndSearch(pageable,"%"+ valueSearch + "%");
    }

    @Override
    public DuAn findById(Long id) {
        return iDuAnRepository.findById(id).get();
    }
}
