package com.controller;

import com.model.FileMusic;
import com.model.FileMusicString;
import com.service.IFileMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/music")
public class FileMusicController {
    @Autowired
    IFileMusicService iFileMusicService;

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

    @PostMapping("")
    public ModelAndView uploadFile(@ModelAttribute FileMusic fileMusic) throws IOException {
        String fileUpload = "D:\\CODEGYM\\Module4\\Homework\\ss04_data_binding_form\\exsercise\\music\\src\\main\\resources\\fileUpload";

        MultipartFile multipartFile = fileMusic.getFileMusic();
        ModelAndView modelAndView = new ModelAndView("/show");
        String fileName = multipartFile.getOriginalFilename();

        if (fileName.endsWith(".mp3")) {

            String filePath = fileUpload + "\\" + fileName;
            FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));

            FileMusicString fileMusicString = new FileMusicString(fileMusic.getId(), fileMusic.getNameMusic(),
                    fileMusic.getAuthor(), fileMusic.getMusicGenres(), filePath);

            modelAndView.addObject("music", fileMusicString);
        } else {
            modelAndView = showFormMusic();
            modelAndView.addObject("errorFile", "Nhập sai định dạng file!");
        }
        return modelAndView;
    }

}
