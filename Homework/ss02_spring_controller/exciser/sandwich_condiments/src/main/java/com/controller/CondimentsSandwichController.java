package com.controller;

import com.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class CondimentsSandwichController {

    @GetMapping("")
    public String showCondiments(){
        return "/showCondiments";
    }

    @Autowired
    ICondimentsService iCondimentsService;
    @PostMapping("/condiments")
    public String result(@RequestParam String[] condiments, Model model){
        model.addAttribute("showList",iCondimentsService.showCondiments(condiments));
        return "/showCondimentsSandWich";
    }
}
