package com.controller;

import com.model.Customer;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("showList", iCustomerService.showList());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.add(customer);
        redirectAttributes.addFlashAttribute("final","Thêm thành công!");
        return "redirect: /customer";
    }

    @PostMapping("remove")
    public String remove(@RequestParam int[] remove){
        for (int s:remove) {
            iCustomerService.remove(s);
        }
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("idCheck",id);
        model.addAttribute("customer",new Customer());
        model.addAttribute("showList", iCustomerService.showList());
        return "/list";

    }


}
