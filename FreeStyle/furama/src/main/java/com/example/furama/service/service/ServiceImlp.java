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
    public List<com.example.furama.model.service.Service> getList() {
        return iServiceRepository.findAll();
    }

    @Override
    public com.example.furama.model.service.Service add(com.example.furama.model.service.Service service) {
        try{
            return  iServiceRepository.save(service);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public com.example.furama.model.service.Service update(com.example.furama.model.service.Service service) {
        try{

            return iServiceRepository.save(service);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<com.example.furama.model.service.Service> findPage(Pageable pageable) {
        return iServiceRepository.findPage(pageable);
    }

    @Override
    public List<com.example.furama.model.service.Service> getService(String service) {
        return iServiceRepository.findAll();
    }

    @Override
    public List<com.example.furama.model.service.Service> findByServiceName(String service) {
        return iServiceRepository.findByServiceName("%" + service + "%");
    }

    @Override
    public com.example.furama.model.service.Service findById(Long id) {
        return iServiceRepository.findById(id).get();
    }
    @Override
    public boolean delete(Long id) {
        try {
            iServiceRepository.deleteContractByService(id);
            iServiceRepository.deleteService(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
}
