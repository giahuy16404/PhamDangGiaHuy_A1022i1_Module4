package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.model.StatusBlog;
import com.example.blog.repository.itf.IBlogRepository;
import com.example.blog.service.itf.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    @Transactional
    public boolean create(Blog blog) {
       Blog blog1 = iBlogRepository.save(blog);
       return blog1 != null;
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findBlogOnDay() {
        return iBlogRepository.findBlogOnDay();
    }



    @Override
    public List<Blog> findBlogTopView() {
        return iBlogRepository.findBlogTopView();
    }



    @Override
    public List<Blog> findById(int id) {
        List<Blog> blogs = new ArrayList<>();
        Blog blog = iBlogRepository.findById(id).orElse(null);
        blogs.add(blog);
        return blogs ;
    }

    @Override
    public boolean update(Blog blog) {
        Blog blog1 = iBlogRepository.save(blog);
        return blog1 != null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try{
            iBlogRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Page<Blog> findBlogByCategory(String category,Pageable pageable) {
        return iBlogRepository.findBlogByCategory("%"+category+"%",pageable);
    }

    @Override
    public Page<Blog> findBlogByAll(String title, String description, String name, Pageable pageable) {
        return iBlogRepository.findBlogByAll("%"+title+"%","%"+description+"%","%"+name+"%",pageable);
    }


}
