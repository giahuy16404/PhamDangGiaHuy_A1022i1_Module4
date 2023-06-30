package com.example.blog.service.itf;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.model.StatusBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService{
    boolean create(Blog blog);
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findBlogOnDay();
    List<Blog> findBlogTopView();
    List<Blog> findById(int id);
    boolean update(Blog blog);




}
