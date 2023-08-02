package com.example.furama.controller.service;

import com.example.furama.dto.serviceDto.ServiceDto;
import com.example.furama.model.service.Service;
import com.example.furama.service.service.itf.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IService iService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "0") int size,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Service> findPage = iService.findPage(pageable);
        model.addAttribute("servicePage", findPage);
        model.addAttribute("valueSearch", valueSearch);
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("serviceType", iService.findServiceType());
        model.addAttribute("rentType", iService.findRentType());
        return "service/list";
    }

    @GetMapping("/add_villa")
    public String addVila(Model model) {
        model.addAttribute("serviceType", iService.findServiceType());
        model.addAttribute("rentType", iService.findRentType());
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/addVilla";
    }

    @GetMapping("/add_house")
    public String addHouse(Model model) {
        model.addAttribute("serviceType", iService.findServiceType());
        model.addAttribute("rentType", iService.findRentType());
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/addHouse";
    }

    @GetMapping("/add_room")
    public String addRoom(Model model) {
        model.addAttribute("serviceType", iService.findServiceType());
        model.addAttribute("rentType", iService.findRentType());
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/addRoom";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ServiceDto serviceDto,
                      BindingResult bindingResult
    ) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            if (serviceDto.getServiceType().getId() == 1) {
                return "service/addVilla";
            } else if (serviceDto.getServiceType().getId() == 2) {
                return "service/addHouse";
            } else {
                return "service/addRoom";
            }
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        iService.add(service);
        return "redirect:/service";
    }

    @PostMapping("update")
    public String update(@ModelAttribute ServiceDto serviceDto) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        iService.update(service);
        return "redirect:/service";
    }
}
