//package com.example.furama.controller.employee;
//
//import com.example.furama.dto.employeeDto.EmployeeDto;
//import com.example.furama.model.account.AppUser;
//import com.example.furama.model.employee.Employee;
//import com.example.furama.service.contract.itf.IContractService;
//import com.example.furama.service.employee.itf.IEmployeeService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/employee")
//
//public class EmployeeController {
//    @Autowired
//    private IEmployeeService iEmployeeService;
//
//    @Autowired
//    private IContractService iContractService;
//
//    @GetMapping("")
//    public String showList(@RequestParam(defaultValue = "0") int page,
//                           @RequestParam(defaultValue = "0") int size,
//                           @RequestParam(defaultValue = "") String valueSearch,
//                           Model model
//    ) {
//        Pageable pageable = PageRequest.of(page, 4);
//        Page<Employee> employeePage;
//        if (valueSearch.equals("")) {
//            employeePage = iEmployeeService.findPage(pageable);
//        } else {
//            employeePage = iEmployeeService.searchByName(pageable, valueSearch);
//        }
//        model.addAttribute("employeePage", employeePage);
//        model.addAttribute("valueSearch", valueSearch);
//        return "employee/list";
//    }
//
//    @GetMapping("/update/{id}")
//    public String update(@PathVariable Long id,Model model){
//        model.addAttribute("employee",iEmployeeService.findById(id));
//        model.addAttribute("position", iEmployeeService.findPosition());
//        model.addAttribute("division", iEmployeeService.findDivision());
//        model.addAttribute("education", iEmployeeService.findEducation());
//        return "employee/update";
//    }
//
//    @GetMapping("/add")
//    public String add(Model model) {
//        model.addAttribute("employeeDto", new EmployeeDto());
//        model.addAttribute("position", iEmployeeService.findPosition());
//        model.addAttribute("division", iEmployeeService.findDivision());
//        model.addAttribute("education", iEmployeeService.findEducation());
//        return "employee/add";
//    }
//
//    @PostMapping("/add")
//    public String add( @ModelAttribute EmployeeDto employeeDto,
//                      BindingResult bindingResult,
//                      RedirectAttributes redirectAttributes) {
//        new EmployeeDto().validate(employeeDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "employee/add";
//        }
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto, employee);
//        AppUser appUser = new AppUser();
//        appUser.setUserName("Huy");
//        appUser.setPassWord("123");
//        employee.setUser(appUser);
//        if (iEmployeeService.add(employee)){
//            redirectAttributes.addFlashAttribute("successCreate", "Thêm mới thành công!");
//        }else {
//            redirectAttributes.addFlashAttribute("successCreate", "Thêm mới không thành công!");
//        }
//
//        return "redirect:/employee";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute Employee employee) {
//        AppUser appUser = new AppUser();
//        appUser.setUserName("Huy");
//        appUser.setPassWord("123");
//        employee.setUser(appUser);
//        iEmployeeService.update(employee);
//        return "redirect:/employee";
//    }
//
//    @PostMapping("/remove")
//    public String remove(@RequestParam List<Long> idRemove) {
//
//        for (Long id : idRemove) {
//            iEmployeeService.remove(id);
//        }
//        return "redirect:/employee";
//    }
//
//
//}
