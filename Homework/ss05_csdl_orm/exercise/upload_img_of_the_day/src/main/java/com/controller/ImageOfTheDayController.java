package com.controller;

import com.model.ImageOfTheDay;
import com.model.ScoringScale;
import com.service.IImageOfTheDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/image-of-the-day")
public class ImageOfTheDayController {
    @Autowired
    private IImageOfTheDayService iImageOfTheDayService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("showComment");
        modelAndView.addObject("list", iImageOfTheDayService.findAll());
        return modelAndView;
    }

    @GetMapping("/comment")
    public ModelAndView showCreateComment() {
        ModelAndView modelAndView = new ModelAndView("createComment");
        modelAndView.addObject("ImageOfTheDay", new ImageOfTheDay());
        List<ScoringScale> list = iImageOfTheDayService.finAllScoringScale();
        modelAndView.addObject("listScor", list);
        return modelAndView;
    }

    @PostMapping("/comment")
    public String createComment(ImageOfTheDay imageOfTheDay, RedirectAttributes redirectAttributes) {
        LocalDate date = LocalDate.now();
        imageOfTheDay.setStartDate(date);
        imageOfTheDay.setLikeComment(0);
        iImageOfTheDayService.add(imageOfTheDay);
        String mess = "Thêm mới đánh giá thành công";
        redirectAttributes.addFlashAttribute("message", mess);
        return "redirect:/image-of-the-day";
    }

    @GetMapping("/likeComment/{id}")
    public String likeComment(@PathVariable Long id) {
        iImageOfTheDayService.likeComment(id);
        return "redirect:/image-of-the-day";
    }

}
