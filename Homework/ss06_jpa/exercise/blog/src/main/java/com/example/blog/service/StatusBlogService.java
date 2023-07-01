package com.example.blog.service;

import com.example.blog.model.StatusBlog;
import com.example.blog.repository.itf.IStatusBlogRepository;
import com.example.blog.service.itf.IStatusBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StatusBlogService implements IStatusBlogService {
    @Autowired
    private IStatusBlogRepository iStatusBlogRepository;
    @Override
    @Transactional
    public boolean create(StatusBlog statusBlog) {
        StatusBlog statusBlog1 = iStatusBlogRepository.save(statusBlog);
        return statusBlog1 != null;
    }

    @Override
    public boolean update(StatusBlog statusBlog) {
        StatusBlog statusBlog1 = iStatusBlogRepository.save(statusBlog);
        return statusBlog1 != null;
    }

    @Override
    public int showMaxId() {
        return iStatusBlogRepository.showMaxId();
    }
    @Override
    @Transactional
    public boolean addLike(int id) {
        try{
            iStatusBlogRepository.addLike(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            iStatusBlogRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean addView(int id) {
        try{
            iStatusBlogRepository.addView(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
