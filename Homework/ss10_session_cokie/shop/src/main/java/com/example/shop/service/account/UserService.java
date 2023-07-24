package com.example.shop.service.account;

import com.example.shop.model.account.User;
import com.example.shop.model.account.UserRole;
import com.example.shop.repository.account.IUserRepository;
import com.example.shop.service.account.imlp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public boolean add(User user) {
        try {
            iUserRepository.save(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(User user) {
        User user1 = findById(user.getId());
        if (user1 == null){
            return false;
        }
        iUserRepository.save(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        User user1 = findById(user.getId());
        if (user1 == null){
            return false;
        }
        iUserRepository.delete(user);
        return true;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }
}
