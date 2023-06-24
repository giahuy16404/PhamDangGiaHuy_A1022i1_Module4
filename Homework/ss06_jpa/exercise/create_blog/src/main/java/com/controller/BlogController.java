package com.controller;

import com.model.Author;
import com.model.Blog;
import com.model.StatusBlog;
import com.service.itf.IAuthorService;
import com.service.itf.IBlogService;
import com.service.itf.IStatusBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IAuthorService iAuthorService;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private IStatusBlogService iStatusBlogService;
    @GetMapping("/create")
    public ModelAndView showCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("createBlog");
        modelAndView.addObject("obBlog",new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBlog(Author author){

        return "redirect:/blog";
    }

    @GetMapping("")
    public ModelAndView showMain(){
        ModelAndView modelAndView = new ModelAndView("/main");
        return modelAndView;
    }

}
