package com.example.furama.service.service.itf;

import com.example.furama.model.service.RentType;
import com.example.furama.model.service.Service;
import com.example.furama.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IService {
   List<ServiceType> findServiceType();
   List<RentType> findRentType();
   List<Service> getList();
   Service add(Service service);
   Service update(Service service);
   Page<Service> findPage(Pageable pageable);
   List<Service> getService(String service);

   List<Service> findByServiceName(String service);

   Service findById(Long id);
   boolean delete(Long id);


}
