package com.example.blog.controller;

//import com.example.blog.config.LocalDateFormatString;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.model.StatusBlog;
import com.example.blog.service.itf.IAuthorService;
import com.example.blog.service.itf.IBlogService;
import com.example.blog.service.itf.IStatusBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
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
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("blogTopView",iBlogService.findBlogTopView());
        modelAndView.addObject("blogOnDay",iBlogService.findBlogOnDay());
        return modelAndView;
    }



    @GetMapping("/showBlog/{idBlog}")
    public ModelAndView showBlog(RedirectAttributes redirectAttributes,@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        redirectAttributes.addFlashAttribute("blogById",iBlogService.findById(idBlog));
        return modelAndView;
    }



    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("list");
        Pageable pageable = PageRequest.of(page,8);
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        modelAndView.addObject("blogPage",blogPage);
//        modelAndView.addObject("showList",iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{idBlog}")
    public ModelAndView viewBlog(@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("/viewBlog");

        modelAndView.addObject("viewBlog",iBlogService.findById(idBlog));
        return modelAndView;
    }

    @GetMapping("/addView/{idStatusBlog}/{idBlog}")
    public ModelAndView addView(@PathVariable int idStatusBlog, @PathVariable int idBlog, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog",idBlog);
        iStatusBlogService.addView(idStatusBlog);
        return modelAndView;
    }

    @GetMapping("/addLike/{idStatusBlog}/{idBlog}")
    public ModelAndView addLike( @PathVariable int idStatusBlog,@PathVariable int idBlog,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog",idBlog);
        iStatusBlogService.addLike(idStatusBlog);
        return modelAndView;
    }

    @GetMapping("/update/{idBlog}")
    public ModelAndView update(@PathVariable int idBlog){
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("objBlog",iBlogService.findById(idBlog));
        modelAndView.addObject("updateObjBlog",new Blog());
        return modelAndView;
    }

    @PostMapping("/update/{idBlog}")
    public ModelAndView update( Blog blog,@PathVariable int idBlog,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog",idBlog);
        StatusBlog statusBlog = new StatusBlog();
        Author author = new Author();

        //CREATE TABLE AUTHOR
        author.setName(blog.getAuthor().getName());
        author.setIdAuthor(idBlog);
        iAuthorService.update(author);


        //CREATE TABLE STATUS_BLOG
        statusBlog.setTimeCreateBlog(blog.getStatusBlog().getTimeCreateBlog());
        statusBlog.setTimeViewBlog(blog.getStatusBlog().getTimeViewBlog());


        statusBlog.setLikeBlog(blog.getStatusBlog().getLikeBlog());
        statusBlog.setViewBlog(blog.getStatusBlog().getViewBlog());
        statusBlog.setIdStatusBlog(idBlog);
        iStatusBlogService.update(statusBlog);


        //CREATE TABLE BLOG
        Blog newBlog = new Blog(idBlog,author,blog.getTitle(),blog.getDescription(),blog.getContent(),statusBlog);
        iBlogService.update(newBlog);

        return modelAndView;
    }
}
