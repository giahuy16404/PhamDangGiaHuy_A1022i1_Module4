package com.example.blog.repository.itf;
import com.example.blog.model.Blog;
import com.example.blog.repository.QueryDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = QueryDb.SELECT_BLOG_ON_DAY,nativeQuery = true)
    List<Blog> findBlogOnDay();

    @Query(value = QueryDb.SELECT_BLOG_TOP_VIEW,nativeQuery = true)
    List<Blog> findBlogTopView();

    @Query(value = QueryDb.SELECT_BLOG_BY_CATEGORY,nativeQuery = true)
    Page<Blog> findBlogByCategory(@Param("id") String category, Pageable pageable);

    @Query(value = QueryDb.SELECT_BLOG_BY_SEARCH_ALL,nativeQuery = true)
    Page<Blog> findBlogByAll(@Param("title") String title,@Param("description") String description,@Param("name") String name,Pageable pageable);

    @Query(value = QueryDb.FIND_ALL_BLOG,nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

}
