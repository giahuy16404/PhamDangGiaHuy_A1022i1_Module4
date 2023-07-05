package com.example.blog.controller;

//import com.example.blog.config.LocalDateFormatString;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.User;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.model.StatusBlog;
import com.example.blog.service.itf.IBlogService;
import com.example.blog.service.itf.ICategoryService;
import com.example.blog.service.itf.IStatusBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private IStatusBlogService iStatusBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/create")
    public ModelAndView showCreateBlog() {
        ModelAndView modelAndView = new ModelAndView("createBlog");
        modelAndView.addObject("obBlogDto", new BlogDto());
        modelAndView.addObject("categoryList", iCategoryService.findCategory());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBlog(BlogDto blogDto, BindingResult bindingResult) {
//        new AuthorDto().validate(blogDto,bindingResult);
//        if (bindingResult.hasErrors()){
//            return "/createBlog";
//        }
        User user = new User();
        StatusBlog statusBlog = new StatusBlog();
        Category category = new Category();
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);


        //CREATE TABLE AUTHOR
        user.setName(blogDto.getAuthor().getName());
        user.setAge(blogDto.getAuthor().getAge());
        user.setEmail(blogDto.getAuthor().getEmail());
        user.setGender(blogDto.getAuthor().getGender());
        user.setPhoneNumber(blogDto.getAuthor().getPhoneNumber());

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
        return "redirect:/blog";
    }

    @GetMapping("")
    public ModelAndView showMain() {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("blogTopView", iBlogService.findBlogTopView());
        modelAndView.addObject("blogOnDay", iBlogService.findBlogOnDay());
        modelAndView.addObject("categoryList", iCategoryService.findCategory());
        return modelAndView;
    }


    @GetMapping("/showBlog/{idBlog}")
    public ModelAndView showBlog(RedirectAttributes redirectAttributes, @PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        redirectAttributes.addFlashAttribute("blogById", iBlogService.findById(idBlog));

        return modelAndView;
    }


    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "") String valueSearch,
                                 @RequestParam(defaultValue = "") String category
    ) {
        ModelAndView modelAndView = new ModelAndView("list");
        Pageable pageable = PageRequest.of(page, 8);
        Page<Blog> blogPage;
        if (!valueSearch.equals("")) {
            blogPage = iBlogService.findBlogByAll(valueSearch, valueSearch, valueSearch, pageable);
        } else if (!category.equals("")) {
            blogPage = iBlogService.findBlogByCategory(category, pageable);
        }else {
            blogPage = iBlogService.findAll(pageable);
        }
        modelAndView.addObject("blogPage", blogPage);
        modelAndView.addObject("valueSearch",valueSearch);
        modelAndView.addObject("category",category);
        modelAndView.addObject("categoryList", iCategoryService.findCategory());
        return modelAndView;
    }

    @GetMapping("/view/{idBlog}")
    public ModelAndView viewBlog(@PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/viewBlog");
        modelAndView.addObject("categoryList", iCategoryService.findCategory());
        modelAndView.addObject("viewBlog", iBlogService.findById(idBlog));
        return modelAndView;
    }

    @GetMapping("/addView/{idStatusBlog}/{idBlog}")
    public ModelAndView addView(@PathVariable int idStatusBlog, @PathVariable int idBlog, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog", idBlog);
        iStatusBlogService.addView(idStatusBlog);
        return modelAndView;
    }

    @GetMapping("/addLike/{idStatusBlog}/{idBlog}")
    public ModelAndView addLike(@PathVariable int idStatusBlog, @PathVariable int idBlog, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog", idBlog);
        iStatusBlogService.addLike(idStatusBlog);
        return modelAndView;
    }

    @GetMapping("/update/{idBlog}")
    public ModelAndView update(@PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("objBlog", iBlogService.findById(idBlog));
        modelAndView.addObject("updateObjBlog", new Blog());
        modelAndView.addObject("categoryList", iCategoryService.findCategory());
        return modelAndView;
    }

    @PostMapping("/update/{idBlog}")
    public ModelAndView update(Blog blog, @PathVariable int idBlog, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/view/{idBlog}");
        redirectAttributes.addFlashAttribute("idBlog", idBlog);
        StatusBlog statusBlog = new StatusBlog();
        User user = new User();
        Category category = new Category();



        //CREATE TABLE AUTHOR
        user.setName(blog.getUser().getName());
        user.setIdUser(idBlog);

        //CREATE TABLE STATUS_BLOG
        statusBlog.setTimeCreateBlog(blog.getStatusBlog().getTimeCreateBlog());
        statusBlog.setTimeViewBlog(blog.getStatusBlog().getTimeViewBlog());
        statusBlog.setLikeBlog(blog.getStatusBlog().getLikeBlog());
        statusBlog.setViewBlog(blog.getStatusBlog().getViewBlog());
        statusBlog.setIdStatusBlog(idBlog);
        iStatusBlogService.update(statusBlog);

        //Category
        category.setIdCategory(blog.getCategory().getIdCategory());

        //CREATE TABLE BLOG
        Blog newBlog = new Blog(idBlog, user, blog.getTitle(), blog.getDescription(), blog.getContent(), statusBlog, category);
        iBlogService.update(newBlog);

        return modelAndView;
    }

    @GetMapping("/delete/{idBlog}")
    public ModelAndView delete(@PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/list");
        iBlogService.delete(idBlog);
        iStatusBlogService.delete(idBlog);
        return modelAndView;
    }

//    @GetMapping("/showBlogByCategory/{idCategory}")
//    public ModelAndView showBlogByCategory(@PathVariable String idCategory,
//                                           @RequestParam(defaultValue = "0") int page
//    ) {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        Pageable pageable = PageRequest.of(page, 8);
//        Page<Blog> blogPage = iBlogService.findBlogByCategory(idCategory, pageable);
//        modelAndView.addObject("categoryList", iCategoryService.findCategory());
//        modelAndView.addObject("blogPage", blogPage);
//        return modelAndView;
//    }
//
//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam(defaultValue = "0") int page) {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        Pageable pageable = PageRequest.of(page, 8);
//        Page<Blog> blogPage = iBlogService.findBlogByAll(valueSearch, valueSearch, valueSearch, pageable);
//        modelAndView.addObject("categoryList", iCategoryService.findCategory());
//        modelAndView.addObject("blogPage", blogPage);
//        return modelAndView;
//
//    }

}