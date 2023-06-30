package com.example.blog.repository.itf;
import com.example.blog.model.Blog;
import com.example.blog.repository.QueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = QueryDb.SELECT_BLOG_ON_DAY,nativeQuery = true)
    List<Blog> findBlogOnDay();

    @Query(value = QueryDb.SELECT_BLOG_TOP_VIEW,nativeQuery = true)
    List<Blog> findBlogTopView();


//    boolean create(Blog blog);
//    List<Blog> findAll();
//    List<Blog> findBlogOnDay();
//    List<Blog> findBlogTopView();
//    boolean addView(int id);
//    List<Blog> findById(int id);
//    boolean addLike(int id);



}
