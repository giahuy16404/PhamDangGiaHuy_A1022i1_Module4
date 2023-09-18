package com.example.thi.controller;

import com.example.thi.dto.DuAnDto;
import com.example.thi.model.DuAn;
import com.example.thi.service.IDuAnService;
import com.example.thi.util.FormatDate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("du_an")
public class DuAnController {
    @Autowired
    private IDuAnService iDuAnService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model
    ) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<DuAn> duAnPage = iDuAnService.findPageAndSearch(pageable, valueSearch);
        model.addAttribute("duAnPage", duAnPage);
        model.addAttribute("valueSearch", valueSearch);
        return "/list";
    }

    @GetMapping("/add_du_an")
    public String addDuAn(Model model) {
        model.addAttribute("DoanhNghiepList", iDuAnService.findDoanhNghiep());
        model.addAttribute("duAnDto", new DuAnDto());
        model.addAttribute("date", FormatDate.formatDate(LocalDate.now().toString()));
        return "/add";
    }

    @PostMapping("/add_du_an")
    public String addDuAn(@ModelAttribute DuAnDto duAnDto, BindingResult bindingResult, Model model) {
        new DuAnDto().validate(duAnDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("DoanhNghiepList", iDuAnService.findDoanhNghiep());
            model.addAttribute("date", FormatDate.formatDate(LocalDate.now().toString()));
            return "/add";
        }
        DuAn duAn = new DuAn();
        BeanUtils.copyProperties(duAnDto, duAn);
        duAn.setNgayDangKy(LocalDate.now().toString());
        double result = 0;
        if (duAn.getKinhPhiYeuCau() < 100000000) {
            result = (duAn.getKinhPhiYeuCau() * 0.1) * duAn.getThoiGianDangKy();
            duAn.setChiPhi((float) result);
        } else if (duAn.getKinhPhiYeuCau() > 100000000 && duAn.getKinhPhiYeuCau() < 500000000) {
            result = (duAn.getKinhPhiYeuCau() * 0.2) * duAn.getThoiGianDangKy();
            duAn.setChiPhi((float) result);
        }else if (duAn.getKinhPhiYeuCau() > 500000000) {
            result = (duAn.getKinhPhiYeuCau() * 0.3) * duAn.getThoiGianDangKy();
            duAn.setChiPhi((float) result);
        }
        DuAn duAn1 = iDuAnService.addDuAn(duAn);
        duAn1.setCode("DA-" + String.format("%04d", duAn1.getId()));
        iDuAnService.addDuAn(duAn1);
        return "redirect:/du_an";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("duAnDetail", iDuAnService.findById(id));
        return "/detail";
    }
}
