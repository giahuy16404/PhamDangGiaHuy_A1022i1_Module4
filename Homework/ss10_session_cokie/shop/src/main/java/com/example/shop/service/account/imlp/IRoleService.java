package com.example.shop.service.account.imlp;

import com.example.shop.model.account.AppRole;
import com.example.shop.model.account.UserRole;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoleService {

    List<AppRole> findAll();
    List<String> getRoleByUser(long id);

}
