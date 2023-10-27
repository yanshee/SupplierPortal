package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.EmailDetails;

import jakarta.mail.MessagingException;

public interface EmailService {

	String sendSimpleMail(String supplierName);
	
	String sendOtpviamail(String supplierName);
}
