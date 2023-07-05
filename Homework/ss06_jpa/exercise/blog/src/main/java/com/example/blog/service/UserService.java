package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.itf.IAuthorRepository;
import com.example.blog.service.itf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IAuthorRepository iAuthorRepository;
    @Override
    @Transactional
    public boolean create(User user) {
        User user1 = iAuthorRepository.save(user);
        return user1 != null;
    }

    @Override
    public int showMaxId() {
        return iAuthorRepository.showMaxId();
    }

    @Override
    public boolean update(User user) {
        User user1 = iAuthorRepository.save(user);
        return user1 != null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean edit(User user) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try{
            iAuthorRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
