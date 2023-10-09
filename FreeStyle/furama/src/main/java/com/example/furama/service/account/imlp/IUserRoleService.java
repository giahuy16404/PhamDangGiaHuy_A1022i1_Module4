package com.example.furama.service.account.imlp;

import com.example.furama.model.account.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserRoleService  {
    boolean add(UserRole userRole);
    Page<UserRole> findAll(Pageable pageable);
    Page<UserRole> findByName(Pageable pageable, String name);

}
