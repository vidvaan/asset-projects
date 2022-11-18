package com.createiq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSendUtil {
	
	 @Autowired 
	 private JavaMailSender javaMailSender;
	 
	    @Value("${spring.mail.username}") private String sender;
	 
	    // Method 1
	    // To send a simple email
	    public String sendSimpleMail(String recipient,String sub,String msg)
	    {
	 
	        // Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(recipient);
	            mailMessage.setText(msg);
	            mailMessage.setSubject(sub);
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	           throw new RuntimeException(e);
	        }
	    }
}
