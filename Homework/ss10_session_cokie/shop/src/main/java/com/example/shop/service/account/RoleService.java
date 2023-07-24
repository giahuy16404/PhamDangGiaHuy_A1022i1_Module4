package com.example.shop.service.account;

import com.example.shop.model.account.Role;
import com.example.shop.repository.account.IRoleRepository;
import com.example.shop.service.account.imlp.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public List<Role> findAll() {
        return iRoleRepository.findAll();
    }
}
