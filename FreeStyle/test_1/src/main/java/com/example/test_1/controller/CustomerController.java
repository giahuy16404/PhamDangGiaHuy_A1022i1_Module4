package com.example.test_1.controller;

import com.example.test_1.dto.CustomerDto;
import com.example.test_1.model.Customer;
import com.example.test_1.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model
                           ){
        Pageable pageable = PageRequest.of(page,3);
        Page<Customer> customerPage = iCustomerService.findPage(pageable,valueSearch);
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("valueSearch",valueSearch);
        return "/list";

    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("listTypeCustomer",iCustomerService.findCustomerType());
        return "/add";
    }

    @PostMapping("/add")
    private String add(@ModelAttribute CustomerDto customerDto, BindingResult bindingResult){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        Customer customer1 = iCustomerService.add(customer);
        customer1.setCode( "KH-"+ String.format("%04d",customer1.getId()));
        iCustomerService.update(customer1);
        return "redirect:/customer";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam List<Long> idRemove){
        for (Long id: idRemove) {
            iCustomerService.remove(id);
        }
        return "redirect:/customer";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        model.addAttribute("listTypeCustomer",iCustomerService.findCustomerType());
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer){
        iCustomerService.update(customer);
        return "redirect:/customer";
    }
}
