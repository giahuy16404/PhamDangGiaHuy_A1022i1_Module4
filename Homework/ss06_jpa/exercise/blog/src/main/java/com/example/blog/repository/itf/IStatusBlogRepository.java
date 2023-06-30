package com.example.blog.repository.itf;

import com.example.blog.model.Blog;
import com.example.blog.model.StatusBlog;
import com.example.blog.repository.QueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface IStatusBlogRepository extends JpaRepository<StatusBlog,Integer> {
    @Query(value = QueryDb.SELECT_MAX_ID_STATUS_BLOG,nativeQuery = true)
    int showMaxId();
    @Query(value = "UPDATE status_blog SET status_blog.view_blog = status_blog.view_blog + 1 WHERE status_blog.id_status_blog = :id", nativeQuery = true)
    @Modifying
    void addView(@Param("id") int id);

    @Query(value = "UPDATE status_blog SET status_blog.like_blog = status_blog.like_blog + 1 WHERE status_blog.id_status_blog = :id", nativeQuery = true)
    @Modifying
    void addLike(@Param("id") int id);
}
