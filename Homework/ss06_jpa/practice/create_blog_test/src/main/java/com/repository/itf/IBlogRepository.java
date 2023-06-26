package com.repository.itf;

import com.model.Blog;

import java.util.List;

public interface IBlogRepository {
    boolean create(Blog blog);
    List<Blog> findAll();
    List<Blog> findBlogOnDay();
    List<Blog> findBlogTopView();
    boolean addView(int id);
    List<Blog> findById(int id);
    boolean addLike(int id);



}
