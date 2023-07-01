package com.example.blog.service;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.model.StatusBlog;
import com.example.blog.repository.itf.IAuthorRepository;
import com.example.blog.service.itf.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository iAuthorRepository;
    @Override
    @Transactional
    public boolean create(Author author) {
        Author author1 = iAuthorRepository.save(author);
        return author1 != null;
    }

    @Override
    public int showMaxId() {
        return iAuthorRepository.showMaxId();
    }

    @Override
    public boolean update(Author author) {
        Author author1 = iAuthorRepository.save(author);
        return author1 != null;
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
