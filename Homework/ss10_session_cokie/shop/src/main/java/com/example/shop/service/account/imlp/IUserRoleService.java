package com.example.shop.service.account.imlp;

import com.example.shop.model.account.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRoleService  {
    boolean add(UserRole userRole);
    Page<UserRole> findAll(Pageable pageable);
    Page<UserRole> findByName(Pageable pageable, String name);

}
