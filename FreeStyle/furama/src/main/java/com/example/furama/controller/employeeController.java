package com.example.furama.controller;

import com.example.furama.dto.employee.EmployeeDTO;
import com.example.furama.model.employee.AppUser;
import com.example.furama.model.employee.Employee;
import com.example.furama.repository.employee.IPositionRepository;
import com.example.furama.service.employee.itf.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class employeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "0") int size,
                           Model model
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> employeePage = iEmployeeService.findAll(pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("employeeDto", new EmployeeDTO());
        model.addAttribute("position", iEmployeeService.findPosition());
        model.addAttribute("division", iEmployeeService.findDivision());
        model.addAttribute("education", iEmployeeService.findEducation());
        return "employee/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employeeDto", new EmployeeDTO());
        model.addAttribute("position", iEmployeeService.findPosition());
        model.addAttribute("division", iEmployeeService.findDivision());
        model.addAttribute("education", iEmployeeService.findEducation());
        return "employee/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute EmployeeDTO employeeDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        new EmployeeDTO().validate(employeeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "employee/add";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = new AppUser();
        appUser.setUserName("Huy");
        appUser.setPassWord("123");
        employee.setUser(appUser);
        iEmployeeService.add(employee);
        redirectAttributes.addFlashAttribute("successCreate", "Thêm mới thành công!");
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = new AppUser();
        appUser.setUserName("Huy");
        appUser.setPassWord("123");
        employee.setUser(appUser);
        iEmployeeService.update(employee);
        return "redirect:/employee";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam List<Long> name){
        System.out.println(name);
        return "redirect:/employee";
    }
}
