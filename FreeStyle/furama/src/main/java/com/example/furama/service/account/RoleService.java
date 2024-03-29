package com.example.furama.service.account;

import com.example.furama.model.account.AppRole;
import com.example.furama.repository.account.IRoleRepository;
import com.example.furama.service.account.imlp.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public List<String> getRoleByUser(long id) {
        return iRoleRepository.getRoleByUser(id);
    }
}
