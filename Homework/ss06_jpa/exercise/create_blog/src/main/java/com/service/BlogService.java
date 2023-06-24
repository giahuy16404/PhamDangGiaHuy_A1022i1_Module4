package com.service;

import com.model.Blog;
import com.service.itf.IBlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService implements IBlogService {
    @Override
    @Transactional
    public boolean create(Blog blog) {
        return false;
    }
}
