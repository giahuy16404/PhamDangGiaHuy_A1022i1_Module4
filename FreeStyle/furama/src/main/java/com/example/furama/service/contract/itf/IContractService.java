package com.example.furama.service.contract.itf;

import com.example.furama.model.contract.AttachService;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    Contract add(Contract contract);
    Page<Contract> findPage(Pageable pageable);
    List<AttachService> findAttach();

    boolean addContractDetail(ContractDetail contractDetail);

    Long showMaxId();

}
