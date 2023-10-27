package com.bezkoder.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bezkoder.spring.login.security.services.EmailService;
import com.bezkoder.spring.login.security.services.OtpService;

@Controller
@RequestMapping("/api/otp")
public class OtpController {
	
	@Autowired
	private OtpService otpservice;
	
	@Autowired
	private EmailService emailservice;

	
	
	@PostMapping("/sendotp/{supplierName}")
	public void generateOTP() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String supplierName="Yanshee";
		int otp=otpservice.generateOTP(supplierName);
		emailservice.sendOtpviamail(supplierName);
	}
	
	@GetMapping(value ="/validateOtp")
	public @ResponseBody String validateOtp(@RequestParam("otp") int otp){
		
			final String SUCCESS = "Entered Otp is valid";
			final String FAIL = "Entered Otp is NOT valid. Please Retry!";
			Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
			String username = auth.getName();
			//Validate the Otp 
			if(otp >= 0){
				
			  int serverOtp = otpservice.getOtp(username);
				if(serverOtp > 0){
				  if(otp == serverOtp){
					  otpservice.clearOTP(username);
			
					  return ("Entered Otp is valid");
					} 
					else {
						return FAIL;
					   }
				   }else {
				  return FAIL;
				   }
				 }else {
					return FAIL;
			 }
		  }
}
