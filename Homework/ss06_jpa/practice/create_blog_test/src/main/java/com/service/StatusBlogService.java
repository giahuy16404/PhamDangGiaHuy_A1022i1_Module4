package com.service;

import com.model.StatusBlog;
import com.repository.itf.IStatusBlogRepository;
import com.service.itf.IStatusBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusBlogService implements IStatusBlogService {
    @Autowired
    private IStatusBlogRepository iStatusBlogRepository;
    @Override
    public boolean create(StatusBlog statusBlog) {
        try{
            iStatusBlogRepository.create(statusBlog);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int showMaxId() {
        return iStatusBlogRepository.showMaxId();
    }
}
