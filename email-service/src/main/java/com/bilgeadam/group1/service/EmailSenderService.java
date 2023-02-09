package com.bilgeadam.group1.service;

import com.bilgeadam.group1.entity.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    public void sendMail(Email model){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("musty1406@gmail.com");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("Aktivasyon Kodunuz: ");
        mailMessage.setText(model.getActivationCode());
        javaMailSender.send(mailMessage);
    }
}
