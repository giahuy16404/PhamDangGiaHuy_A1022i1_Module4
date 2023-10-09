package com.example.furama.email;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
