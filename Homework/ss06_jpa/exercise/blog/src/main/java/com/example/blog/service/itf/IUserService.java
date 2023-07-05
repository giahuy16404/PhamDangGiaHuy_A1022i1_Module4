package com.example.blog.service.itf;

import com.example.blog.model.User;

import java.util.List;

public interface IUserService {
    boolean create(User user);
    int showMaxId();
    boolean update(User user);

    List<User> findAll();

    boolean edit(User user);
    boolean remove(int id);
    boolean delete(int id);


}
