package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.model.StatusBlog;
import com.example.blog.model.User;
import com.example.blog.service.itf.IBlogService;
import com.example.blog.service.itf.ICategoryService;
import com.example.blog.service.itf.IStatusBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blog")
public class RestBlogController{
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IStatusBlogService iStatusBlogService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/get-category")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> getAll = iCategoryService.findCategory();
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/get-list-blog")
    public ResponseEntity<Page<Blog>> getListBlog(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> getAllBlog = iBlogService.findAll(pageable);

        if (getAllBlog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllBlog, HttpStatus.OK);
    }

    @GetMapping("/get-by-category")
    public ResponseEntity<Page<Blog>> getByCategory(@RequestParam int page, int size, int category) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> getByCategory = iBlogService.findBlogByCategory(category, pageable);
        if (getByCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getByCategory, HttpStatus.OK);
    }

    @GetMapping("/get-book-detail")
    public ResponseEntity<List<Blog>> getBookDetail(@RequestParam int idBlog) {
        List<Blog> blog = iBlogService.findById(idBlog);
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);

    }

    @PostMapping("/create-blog")
    public ResponseEntity<?> create(@RequestBody BlogDto blogDto) {
        StatusBlog statusBlog = new StatusBlog();
        User user = new User();
        Blog blog = new Blog();
        Category category = new Category();


        BeanUtils.copyProperties(blogDto, blog);
        user.setIdUser(blogDto.getIdUser());
        blog.setUser(user);

        //CREATE TABLE STATUS_BLOG
        LocalDate localDate = LocalDate.now();
        statusBlog.setTimeCreateBlog(localDate);
        statusBlog.setTimeViewBlog(localDate);
        statusBlog.setLikeBlog(0L);
        statusBlog.setViewBlog(0L);
        iStatusBlogService.create(statusBlog);
        int maxIdStatusBlog = iStatusBlogService.showMaxId();
        statusBlog.setIdStatusBlog(maxIdStatusBlog);

        //Category
        category.setIdCategory(blog.getCategory().getIdCategory());

        //CREATE TABLE BLOG
        Blog newBlog = new Blog(0, user, blog.getTitle(), blog.getDescription(), blog.getContent(), statusBlog, category);
        iBlogService.create(newBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update-blog")
    public ResponseEntity<?> update(@RequestBody BlogDto blogDto) {
        List<Blog> blog = iBlogService.findById(blogDto.getIdBlog());
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Blog b : blog) {
            blogDto.setStatusBlog(b.getStatusBlog());
            BeanUtils.copyProperties(blogDto, b);
        }

        for (Blog b : blog) {
            iBlogService.update(b);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-blog")
    public ResponseEntity<?> delete(@RequestParam List<Integer> id) {
        for (int i : id) {
            for (Blog blog : iBlogService.findById(i)) {
                if (blog != null) {
                    iBlogService.delete(blog.getIdBlog());
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
