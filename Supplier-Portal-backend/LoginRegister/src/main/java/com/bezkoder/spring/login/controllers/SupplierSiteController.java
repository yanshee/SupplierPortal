package com.bezkoder.spring.login.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.dto.UserDto;
import com.bezkoder.spring.login.models.ERole;
import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.models.SupplierSite;
import com.bezkoder.spring.login.models.User;
//import com.bezkoder.spring.login.payload.request.NewUserRequest;
import com.bezkoder.spring.login.payload.request.SignupRequest;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.repository.SupplierSiteRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import com.bezkoder.spring.login.security.services.SupplierSiteService;
import com.bezkoder.spring.login.security.services.UserDetailsServiceImpl;

import jakarta.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/suppliersite")
public class SupplierSiteController {
	@Autowired
	private SupplierSiteService supplierImpl;
	
	@Autowired
	private SupplierSiteRepository supplierRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	
	@PostMapping("/createAdmUser")
	public ResponseEntity<UserDto> createAdminUser(@RequestBody UserDto user){
		UserDto saveduser=userService.createUser(user);
		return new ResponseEntity<>(saveduser,HttpStatus.CREATED);	
	}
	

	
	@GetMapping("/view")
    public ResponseEntity<List<SupplierSite>> listAllSite(){
    	List<SupplierSite> allSites=supplierImpl.listAll();
		return new ResponseEntity<>(allSites,HttpStatus.CREATED);       
   }
	
	@PutMapping("updateSite/{siteName}")
	 public ResponseEntity<SupplierSite> updateSiteInfo(@RequestBody SupplierSite site, @PathVariable String siteName) {
		SupplierSite newSite=supplierImpl.EditSite(siteName , site);
		return new ResponseEntity<>(newSite,HttpStatus.OK);	
	  }
	 
	 @DeleteMapping("delete/{siteName}")
	    public String deleteSite(@PathVariable String siteName) {
	    	return supplierImpl.deleteSite(siteName);
	    }

}
