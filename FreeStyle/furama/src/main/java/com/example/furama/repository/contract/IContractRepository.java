package com.example.furama.repository.contract;

import com.example.furama.QueryDb.QueryContractDb;
import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Long> {

    @Query(value = QueryContractDb.FIND_PAGE_CONTRACT,nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);
}
