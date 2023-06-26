package com.controller;

import com.model.Author;
import com.model.Blog;
import com.model.StatusBlog;
import com.service.itf.IAuthorService;
import com.service.itf.IBlogService;
import com.service.itf.IStatusBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createBlog(Blog blog){
        Author author = new Author();
        StatusBlog statusBlog = new StatusBlog();

        //CREATE TABLE AUTHOR
        author.setName(blog.getAuthor().getName());
        iAuthorService.create(author);
        int maxIdAuthor = iAuthorService.showMaxId();
        author.setIdAuthor(maxIdAuthor);

        //CREATE TABLE STATUS_BLOG
        LocalDate localDate = LocalDate.now();
        statusBlog.setTimeCreateBlog(localDate);
        statusBlog.setTimeViewBlog(localDate);
        statusBlog.setLikeBlog(0L);
        statusBlog.setViewBlog(0L);
        iStatusBlogService.create(statusBlog);
        int maxIdStatusBlog = iStatusBlogService.showMaxId();
        statusBlog.setIdStatusBlog(maxIdStatusBlog);

        //CREATE TABLE BLOG
        Blog newBlog = new Blog(0,author,blog.getTitle(),blog.getDescription(),blog.getContent(),statusBlog);
        iBlogService.create(newBlog);


        return "redirect:/blog";
    }
    @GetMapping("")
    public ModelAndView showMain(){
        ModelAndView modelAndView = new ModelAndView("/main");
        modelAndView.addObject("blogTopView",iBlogService.findBlogTopView());
        modelAndView.addObject("blogOnDay",iBlogService.findBlogOnDay());
        return modelAndView;
    }

    @GetMapping("/addView/{idStatusBlog}/{idBlog}")
    public ModelAndView addView(@PathVariable int idStatusBlog, @PathVariable int idBlog, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/showBlog/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog",idBlog);
        iBlogService.addView(idStatusBlog);
        return modelAndView;
    }

    @GetMapping("/showBlog/{idBlog}")
    public ModelAndView showBlog(RedirectAttributes redirectAttributes,@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        redirectAttributes.addFlashAttribute("blogById",iBlogService.findById(idBlog));
        return modelAndView;
    }

    @GetMapping("/addLike/{idStatusBlog}/{idBlog}")
    public ModelAndView addLike( @PathVariable int idStatusBlog,@PathVariable int idBlog,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/showBlog/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog",idBlog);
        iBlogService.addLike(idStatusBlog);
        return modelAndView;
    }

}
