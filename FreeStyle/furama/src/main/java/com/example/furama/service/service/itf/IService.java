package com.example.furama.service.service.itf;

import com.example.furama.model.service.RentType;
import com.example.furama.model.service.Service;
import com.example.furama.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
   List<ServiceType> findServiceType();
   List<RentType> findRentType();
   boolean add(Service service);
   boolean update(Service service);
   Page<Service> findPage(Pageable pageable);
   List<Service> getService(String service);

}
