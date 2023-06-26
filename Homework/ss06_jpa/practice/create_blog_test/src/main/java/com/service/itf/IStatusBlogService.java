package com.service.itf;

import com.model.Author;
import com.model.StatusBlog;

public interface IStatusBlogService {
    boolean create(StatusBlog statusBlog);
    int showMaxId();

}
