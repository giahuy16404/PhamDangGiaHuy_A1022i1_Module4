package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("showList", iProductService.showList());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Model model) {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productOb", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Product product) {
        iProductService.add(product);
//        redirectAttributes.addFlashAttribute("final","Thêm thành công!");
        return "redirect: /product";
    }

    @PostMapping("remove")
    public String remove(@RequestParam int[] remove) {
        for (int s : remove) {
            iProductService.remove(s);
        }
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("idCheck", id);
        model.addAttribute("product", new Product());
        model.addAttribute("showList", iProductService.showList());
        return "/list";

    }

    @PostMapping("/edit")
    public ModelAndView doEdit(Product product) {
        iProductService.edit(product);
        ModelAndView modelAndView;
        modelAndView = showList();
        return modelAndView;
    }


}
