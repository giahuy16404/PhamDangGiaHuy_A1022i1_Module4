package com.example.furama.repository.contract;

import com.example.furama.QueryDb.QueryContractDb;
import com.example.furama.QueryDb.QueryServiceDb;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Long> {

    @Query(value = QueryContractDb.FIND_PAGE_CONTRACT,nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = QueryContractDb.SHOW_MAX_ID,nativeQuery = true)
    Long showMaxId();


}
