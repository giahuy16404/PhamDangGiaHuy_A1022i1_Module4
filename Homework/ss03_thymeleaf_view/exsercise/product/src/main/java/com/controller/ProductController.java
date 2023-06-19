package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("showList", iProductService.showList());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("productOb",new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        iProductService.add(product);
        redirectAttributes.addFlashAttribute("final","Thêm thành công!");
        return "redirect: /product";
    }

    @PostMapping("remove")
    public String remove(@RequestParam int[] remove){
        for (int s:remove) {
            iProductService.remove(s);
        }
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("idCheck",id);
        model.addAttribute("product",new Product());
        model.addAttribute("showList", iProductService.showList());
        return "/list";

    }


}
