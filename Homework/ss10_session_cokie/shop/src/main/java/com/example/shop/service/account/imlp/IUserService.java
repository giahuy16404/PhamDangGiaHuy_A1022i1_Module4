package com.example.shop.service.account.imlp;

import com.example.shop.dto.account.UserDto;
import com.example.shop.dto.account.UserRoleDto;
import com.example.shop.model.account.User;
import com.example.shop.model.account.UserRole;
import com.example.shop.repository.account.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    boolean add(User user);

    boolean edit(User user);

    boolean delete(User user);

    Page<User> findAll(Pageable pageable);

    User findById(long id);
}
