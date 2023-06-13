package com.controller;

import com.service.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeNow{
    @GetMapping("/time-now")
    public String show(){
        return "/show";
    }
    @Autowired
    IShowTimeService iShowTimeService;
    @PostMapping("/time-now-world")
    public String showTime(@RequestParam String world, Model model){
        model.addAttribute("showTime",iShowTimeService.showTime(world));
        return "/show";
    }
}
