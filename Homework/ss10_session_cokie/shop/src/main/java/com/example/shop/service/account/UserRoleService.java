package com.example.shop.service.account;

import com.example.shop.model.account.UserRole;
import com.example.shop.repository.account.IUserRoleRepository;
import com.example.shop.service.account.imlp.IUserRoleService;
import com.example.shop.util.MethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public boolean add(UserRole userRole) {
        try {
            iUserRoleRepository.save(userRole);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<UserRole> findAll(Pageable pageable) {
        return iUserRoleRepository.findAll(pageable);
    }

    @Override
    public Page<UserRole> findByName(Pageable pageable, String name) {
        return iUserRoleRepository.findByName(pageable,"%"+ name + "%");
    }


}
