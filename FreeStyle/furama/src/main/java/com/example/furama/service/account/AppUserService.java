package com.example.furama.service.account;

import com.example.furama.model.account.AppUser;
import com.example.furama.repository.account.IUserRepository;
import com.example.furama.service.account.imlp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public AppUser add(AppUser appUser) {
        try {
            return iUserRepository.save(appUser);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean edit(AppUser appUser) {
        return false;
    }

    @Override
    public boolean delete(AppUser appUser) {
        return false;
    }

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public AppUser findById(long id) {
        return null;
    }

    @Override
    public UserDetails getAccountByUsername(String name) {
        return null;
    }
}
