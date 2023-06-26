package com.service.itf;

import com.model.Author;
import com.model.Blog;

import java.util.List;

public interface IBlogService {
    boolean create(Blog blog);
    List<Blog> findAll();
    List<Blog> findBlogOnDay();
    List<Blog> findBlogTopView();
    boolean addView(int id);
    List<Blog> findById(int id);
    boolean addLike(int id);


}
