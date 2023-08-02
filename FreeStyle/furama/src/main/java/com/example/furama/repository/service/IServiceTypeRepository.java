package com.example.furama.repository.service;

import com.example.furama.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
