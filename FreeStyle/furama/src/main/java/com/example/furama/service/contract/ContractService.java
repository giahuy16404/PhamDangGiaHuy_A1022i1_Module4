package com.example.furama.service.contract;

import com.example.furama.model.contract.Contract;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.service.contract.itf.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public boolean add(Contract contract) {
        try{
            iContractRepository.save(contract);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
