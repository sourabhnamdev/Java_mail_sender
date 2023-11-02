package com.example.demo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

		public boolean sendEmail(String subject,String msg, String to) {
	        boolean isMailSend = false;
//	        String host = "smtp.gmail.com" ;
	        String host = "smtp.gmail.com" ;
	        String user = "itsnesskhan@gmail.com";
	        
	        Properties properties = new Properties();
	        
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.auth", "false");
	        
	        Session session = Session.getInstance(properties);
	        
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject(subject);
	            message.setText(msg);
	            Transport.send(message);
	            isMailSend = true;
	            
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        return isMailSend;
	    }

	}

