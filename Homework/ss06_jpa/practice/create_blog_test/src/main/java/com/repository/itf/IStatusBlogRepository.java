package com.repository.itf;

import com.model.StatusBlog;

public interface IStatusBlogRepository {
    boolean create(StatusBlog statusBlog);
    int showMaxId();


}
