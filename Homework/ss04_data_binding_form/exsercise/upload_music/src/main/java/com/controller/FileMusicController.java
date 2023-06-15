package com.controller;

import com.model.FileMusic;
import com.service.IFileMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/music")
public class FileMusicController {
    @GetMapping("")
    public ModelAndView showFormMusic() {
        ModelAndView modelAndView = new ModelAndView("/showAdd");
        modelAndView.addObject("music", new FileMusic());
        return modelAndView;
    }

    @ModelAttribute("musicGenres")
    public String[] musicGenres() {
        return new String[]{"Pop", "Ballad", "Bolero", "indie"};
    }

    @Autowired
    IFileMusicService iFileMusicService;

    @PostMapping("")
    public ModelAndView uploadFile(@ModelAttribute FileMusic fileMusic) {
        ModelAndView modelAndView = new ModelAndView("/show");
        if (iFileMusicService.checkFile(fileMusic.getFileMusic())) {
            iFileMusicService.add(fileMusic);
            modelAndView.addObject("showList", iFileMusicService.showList());
        } else {
            modelAndView = showFormMusic();
            modelAndView.addObject("errorFile", "Nhập sai định dạng file!");
        }
        return modelAndView;
    }
}
