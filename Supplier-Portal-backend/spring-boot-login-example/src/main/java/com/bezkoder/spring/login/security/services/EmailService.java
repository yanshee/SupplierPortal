package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.User;

public interface EmailService {

	String sendSimpleMail(User user);
}
