package com.example.furama.rest_controller.email;

import com.example.furama.email.EmailDetails;
import com.example.furama.email.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/")
public class RestEmailController {
    @Autowired
    private IEmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details) {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }
}
