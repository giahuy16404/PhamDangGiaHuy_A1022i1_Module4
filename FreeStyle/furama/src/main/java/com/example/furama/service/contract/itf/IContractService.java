package com.example.furama.service.contract.itf;

import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    boolean add(Contract contract);
    Page<Contract> findAll(Pageable pageable);

}
