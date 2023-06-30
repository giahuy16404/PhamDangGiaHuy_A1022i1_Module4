package com.example.blog.service.itf;

import com.example.blog.model.StatusBlog;

public interface IStatusBlogService {
    boolean create(StatusBlog statusBlog);
    boolean update(StatusBlog statusBlog);
    int showMaxId();
    boolean addView(int id);

    boolean addLike(int id);
}
