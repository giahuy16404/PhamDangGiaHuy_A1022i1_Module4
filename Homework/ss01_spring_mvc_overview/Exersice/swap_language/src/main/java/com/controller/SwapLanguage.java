package com.controller;

import com.service.ISwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SwapLanguage {
    @GetMapping("/show-swap")
    public String showSwapLanguage(){
        return "showSwap";
    }
    @Autowired
    private ISwapService iSwapService;
    @PostMapping("swap")
    public String swap(@RequestParam String english, Model model){
        model.addAttribute("result",iSwapService.swap(english));
        return "showSwap";
    }
}
