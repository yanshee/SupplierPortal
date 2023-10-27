package com.bezkoder.spring.login.security.services;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.bezkoder.spring.login.models.EmailDetails;
//import com.bezkoder.spring.login.models.EmailDetails;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService{

	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private OtpService otp;
	 
    @Value("${spring.mail.username}") private String sender;
 
	@Override
	public String sendSimpleMail(String supplierName) {
		
		try {	        	
	        	User exist = user.findBySupplierName(supplierName).get();
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage= new SimpleMailMessage();
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(exist.getEmail());
	            mailMessage.setText("Your login Id is:-" + exist.getSupplierName() + "and Password is:- " + exist.getPassword());
	            mailMessage.setSubject("Login Credentials");
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }

	@Override
	public String sendOtpviamail(String supplierName) {
		 try {
	        	
	        	User exist = user.findBySupplierName(supplierName).get();
	            SimpleMailMessage mailMessage= new SimpleMailMessage();
	            
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(exist.getEmail());
	            mailMessage.setText("OTP :-"+otp.getOtp(supplierName));
	            mailMessage.setSubject("OTP for setting new password");
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	}
	

//	@Override
//	public String sendOtpviamail(String to, String subject, String message) {
//		try {
//		
//		MimeMessage msg = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(message, true);
//
//        javaMailSender.send(msg);
//        return "Mail Sent Successfully...";
//	}
//		
//		catch (Exception e) {
//            return "Error while Sending Mail";
//        }
//
//	}
	 
}
