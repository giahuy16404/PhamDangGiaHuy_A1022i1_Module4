package com.example.furama.service.account.imlp;

import com.example.furama.model.account.AppRole;

import java.util.List;

public interface IRoleService {

    List<AppRole> findAll();
    List<String> getRoleByUser(long id);

}
