package com.example.furama.repository.service;

import com.example.furama.QueryDb.QueryServiceDb;
import com.example.furama.model.service.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service,Long> {
    @Query(value = QueryServiceDb.FIND_ALL_PAGE_SERVICE,nativeQuery = true)
    Page<Service> findPage(Pageable pageable);

    @Query(value = QueryServiceDb.FIND_BY_SERVICE_NAME,nativeQuery = true)
    List<Service> findByServiceName(@Param("service") String service);
    @Modifying
    @Transactional
    @Query(value = QueryServiceDb.DELETE_SERVICE_BY_ID, nativeQuery = true)
    void deleteService(@Param("id") Long id) throws DataAccessException;

    @Modifying
    @Transactional
    @Query(value = QueryServiceDb.DELETE_CONTRACT_BY_ID_SERVICE, nativeQuery = true)
    void deleteContractByService(@Param("id") Long id) throws DataAccessException;


}
