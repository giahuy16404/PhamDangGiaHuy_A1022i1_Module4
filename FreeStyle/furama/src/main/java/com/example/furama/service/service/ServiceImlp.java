package com.example.furama.service.service;

import com.example.furama.model.service.RentType;
import com.example.furama.model.service.ServiceType;
import com.example.furama.repository.service.IRentTypeRepository;
import com.example.furama.repository.service.IServiceRepository;
import com.example.furama.repository.service.IServiceTypeRepository;
import com.example.furama.service.service.itf.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ServiceImlp implements IService {
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public List<ServiceType> findServiceType() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findRentType() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public boolean add(com.example.furama.model.service.Service service) {
        try{
            iServiceRepository.save(service);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(com.example.furama.model.service.Service service) {
        try{
            iServiceRepository.save(service);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<com.example.furama.model.service.Service> findPage(Pageable pageable) {
        return iServiceRepository.findPage(pageable);
    }

    @Override
    public List<com.example.furama.model.service.Service> getService(String service) {
        return iServiceRepository.findAll();
    }
}
