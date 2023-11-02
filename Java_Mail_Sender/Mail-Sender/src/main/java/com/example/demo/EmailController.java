package com.example.demo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String home(org.springframework.security.core.Authentication authentication, OAuth2AuthenticationToken tokent) {
        	System.out.println(tokent);
    	return "Welcome to OAUTH2 home page"+" "+authentication;
    }
    
    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest request) {
        emailService.sendEmail(request.getSubject(), request.getBody(), request.getTo());
    }
}

