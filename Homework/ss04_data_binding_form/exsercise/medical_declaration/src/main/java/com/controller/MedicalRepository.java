package com.controller;

import com.model.EndDay;
import com.model.Medical;
import com.model.StarDay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MedicalRepository {
    List<Medical> list = new ArrayList<>();

    @GetMapping("/medical")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/showForm");
        modelAndView.addObject("medical", new Medical());
        return modelAndView;
    }

    @PostMapping("/medical")
    public ModelAndView save(@ModelAttribute Medical medical) {
        ModelAndView modelAndView = new ModelAndView("/showForm");
        list.add(medical);
        System.out.println(medical.getSymptom().getYes());
        return modelAndView;
    }

    @ModelAttribute("yearOfBirth")
    public String[] yearOfBirth() {
        return new String[]{"1990", "1991", "1992", "1993"};
    }

    @ModelAttribute("dayOfBirth")
    public List<Integer> dayOfBirth() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            list.add(i);
        }
        return list;
    }

    @ModelAttribute("monthOfBirth")
    public List<Integer> monthOfBirth() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            list.add(i);
        }
        return list;
    }

    @ModelAttribute("nationality")
    public String[] nationality() {
        return new String[]{"Viet Nam", "China", "Thai Lan", "Usa"};
    }

    @ModelAttribute("travelInformation")
    public String[] travelInformation() {
        return new String[]{"Tau bay", "Tau Thuyen", "Oto", "Khac(Ghi ro)"};
    }

    @ModelAttribute("town")
    public String[] town() {
        return new String[]{"Da Nang", "HCM", "Ha Noi", "Quang Nam"};
    }

    @ModelAttribute("county")
    public String[] County() {
        return new String[]{"Son Tra", "Thanh Xuan", "Thanh khe", "Quan 8"};
    }

    @ModelAttribute("ward")
    public String[] Ward() {
        return new String[]{"Phuoc my", "An hai tay", "B", "C"};
    }

    @ModelAttribute("symptom")
    public String[] symptom() {
        return new String[]{"Sot", "Ho", "Kho Tho", "Dau Hong", "Non", "Tieu chay", "Xuat Huyet", "Noi ban"};
    }

    @ModelAttribute("symptomb")
    public String[] symptomb() {
        return new String[]{""};
    }
}
