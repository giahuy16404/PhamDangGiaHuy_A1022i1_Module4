package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.itf.IBlogRepository;
import com.example.blog.repository.itf.ICategoryRepository;
import com.example.blog.service.itf.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class CategoryRepository implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findCategory() {
        return iCategoryRepository.findAll();
    }
}
