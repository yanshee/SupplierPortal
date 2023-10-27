package com.bezkoder.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

import com.bezkoder.spring.login.models.EmailDetails;
import com.bezkoder.spring.login.models.User;


@Service
public class EmailServiceImpl implements EmailService{

	@Autowired 
	private JavaMailSender javaMailSender;
	 
    @Value("${spring.mail.username}") private String sender;
 
	@Override
	public String sendSimpleMail(User user) {
		// TODO Auto-generated method stub
		try {
			 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(user.getEmail());
            mailMessage.setText("Your login id is : "+ user.getId() + "and your password is :"+ user.getPassword());
            mailMessage.setSubject("Login Details for Supplier Portal");
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
	}

}
