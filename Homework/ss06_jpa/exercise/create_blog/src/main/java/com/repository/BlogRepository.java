package com.repository;

import com.model.Blog;
import com.repository.itf.IBlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class BlogRepository implements IBlogRepository {
    @Override
    @Transactional
    public boolean create(Blog blog) {
        return false;
    }
}
