package com.controller;

import com.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("")
    public String showCaculator() {
        return "/showCaculator";
    }

    @PostMapping("/result")
    public String resultCaculator(@RequestParam int num1, @RequestParam int num2, @RequestParam String calculations, Model model) {
        if (calculations.equals("/") & num2 == 0) {
            model.addAttribute("result", "Số chia phải khác 0!");
        } else {
            model.addAttribute("result", iCaculatorService.resultCaculator(num1, num2, calculations));
        }
        return "/showCaculator";
    }
}
