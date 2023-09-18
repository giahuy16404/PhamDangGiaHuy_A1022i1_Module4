package com.example.furama.service.contract;

import com.example.furama.model.contract.AttachService;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.repository.contract.IAttachRepository;
import com.example.furama.repository.contract.IContractDetailRepository;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.service.contract.itf.IContractService;
import com.example.furama.util.FormatDate;
import com.example.furama.util.FormatDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Autowired
    private IAttachRepository iAttachRepository;

    @Override
    public Contract add(Contract contract) {
        try {
            Contract a = iContractRepository.save(contract);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Contract> findPage(Pageable pageable) {
        Page<Contract> contract = iContractRepository.findAll(pageable);
        for (Contract c:contract) {
            c.setStarDate(FormatDateTime.formatDateTime(c.getStarDate()));
        }
        return contract;
    }

    @Override
    public List<AttachService> findAttach() {
        return iAttachRepository.findAll();
    }

    @Override
    public boolean addContractDetail(ContractDetail contractDetail) {
        try {
            iContractDetailRepository.save(contractDetail);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Long showMaxId() {
        return iContractRepository.showMaxId();
    }

}
