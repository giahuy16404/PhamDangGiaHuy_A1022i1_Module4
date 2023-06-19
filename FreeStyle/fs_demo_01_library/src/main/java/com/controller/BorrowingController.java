package com.controller;

import com.model.Book;
import com.model.Borrowing;
import com.model.Student;
import com.service.itf.IBorrowingService;
import com.service.itf.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/library")
public class BorrowingController {
    @Autowired
    IBorrowingService iBorrowingService;
    @Autowired
    IStudentService iStudentService;
    @GetMapping("/show-borrowing/{count}/{nameBook}/{idBook}")
    public String showAdd(@PathVariable int count, @PathVariable String nameBook, @PathVariable int idBook , Model model) {
        model.addAttribute("count",count);
        model.addAttribute("nameBook",nameBook);
        model.addAttribute("idBook",idBook);
        model.addAttribute("getStudent",iStudentService.findAll());
        LocalDate localDate = LocalDate.now();
        model.addAttribute("starDate",localDate.toString());
        return "/showAdd";
    }

    @PostMapping("/add-borrowing")
    public String doAdd(@RequestParam int idBook,@RequestParam int student,
                        @RequestParam String starDate, @RequestParam String endDate){
        Book book1 = new Book();
        book1.setIdBook(idBook);
        Student student1 = new Student();
        student1.setIdStudent(student);
        iBorrowingService.add(new Borrowing(0,book1,student1,true,starDate,endDate));
        return "redirect:/library/show-borrowing";
    }

    @GetMapping("/show-borrowing")
    public String showBorrowing(Model model){
        model.addAttribute("showList",iBorrowingService.findAll());
        return "/showBorrowing";
    }

}
