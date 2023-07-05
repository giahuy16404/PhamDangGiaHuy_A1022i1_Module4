package com.example.blog.controller;

import com.example.blog.dto.UserDto;
import com.example.blog.model.User;
import com.example.blog.service.itf.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("createUser");
        modelAndView.addObject("userDto",new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "createUser";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.create(user);
        return "redirect:/blog";
    }
}
