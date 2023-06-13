package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailValidate {
    @GetMapping("/email")
    public String showEmail(){
        return "/showEmail";
    }

    @PostMapping("/checkEmail")
    public String check(@RequestParam String email, Model model){
        boolean check = email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$;");
        if (check){
            model.addAttribute("email", "hi" +email);
        }else {
            model.addAttribute("check","Email nhap sai dinh dang!");
        }
        return "/check";
    }


}
