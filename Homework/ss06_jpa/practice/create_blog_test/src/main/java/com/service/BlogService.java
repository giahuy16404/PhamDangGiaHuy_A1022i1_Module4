package com.service;

import com.model.Blog;
import com.repository.itf.IAuthorRepository;
import com.repository.itf.IBlogRepository;
import com.service.itf.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    @Transactional
    public boolean create(Blog blog) {
        try{
            iBlogRepository.create(blog);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findBlogOnDay() {
        return iBlogRepository.findBlogOnDay();
    }

    @Override
    public List<Blog> findBlogTopView() {
        return iBlogRepository.findBlogTopView();
    }

    @Override
    public boolean addView(int id) {
        try{
            iBlogRepository.addView(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public boolean addLike(int id) {
        try{
            iBlogRepository.addLike(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
