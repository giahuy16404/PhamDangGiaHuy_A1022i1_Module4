package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.service.ISwapMoney;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SwapController {

    @GetMapping("/showSwap")
    public String showSwap(){
        return "showSwap";
    }
    @Autowired
    private ISwapMoney iSwapMoney;
    @PostMapping("/swap")
    public String swap(@RequestParam double usd, Model model){
        model.addAttribute("result",iSwapMoney.swap(usd) + " VND");
        return "showSwap";
    }

}
