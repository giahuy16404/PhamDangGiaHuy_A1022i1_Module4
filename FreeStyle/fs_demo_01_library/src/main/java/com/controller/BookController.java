package com.controller;

import com.service.itf.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    IBookService iBookService;
    @GetMapping("/book")
    public String showBook(Model model){
        model.addAttribute("showList",iBookService.findAll());
        return "/showBook";
    }
}
