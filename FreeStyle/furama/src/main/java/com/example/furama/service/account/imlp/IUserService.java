package com.example.furama.service.account.imlp;

import com.example.furama.model.account.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    AppUser add(AppUser appUser);

    boolean edit(AppUser appUser);

    boolean delete(AppUser appUser);

    Page<AppUser> findAll(Pageable pageable);

    AppUser findById(long id);
    UserDetails getAccountByUsername(String name);

}
