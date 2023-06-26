package com.service;

import com.model.Author;
import com.repository.itf.IAuthorRepository;
import com.service.itf.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository iAuthorRepository;
    @Override
    public boolean create(Author author) {
        try {
            iAuthorRepository.create(author);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int showMaxId() {
        return iAuthorRepository.showMaxId();
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public boolean edit(Author author) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
