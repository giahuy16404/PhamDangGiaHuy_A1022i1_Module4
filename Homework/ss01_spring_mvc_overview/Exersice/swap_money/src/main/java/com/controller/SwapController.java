package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ISwapMoney;

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
    public String swap(HttpServletRequest request, Model model){
        double usd = Double.parseDouble(request.getParameter("usd"));
        model.addAttribute("result",iSwapMoney.swap(usd));
        return "showSwap";
    }

}
