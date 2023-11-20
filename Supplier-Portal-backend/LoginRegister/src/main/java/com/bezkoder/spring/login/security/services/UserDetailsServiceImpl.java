package com.bezkoder.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.spring.login.dto.UserDto;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.ModuleRepository;
import com.bezkoder.spring.login.repository.SupplierSiteRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import com.bezkoder.spring.login.models.SupplierSite;
import com.bezkoder.spring.login.models.Modules;

import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  SupplierSiteRepository supplierRepo;
  
  @Autowired
  ModuleRepository moduleRepo;
 
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findBySupplierName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
 
  public User EditUser(String username, User user) {
	  if(userRepository.findBySupplierName(username)==null) {
		  new UsernameNotFoundException("Username not Found");
	  } 
		  User existUser=userRepository.findBySupplierName(username).get();
		  existUser.setSupplierName(user.getSupplierName());
		  existUser.setEmail(user.getEmail());
		  existUser.setMobile(user.getMobile());
		  existUser.setModule(user.getModule());
		  existUser.setSite(user.getSite());
		  User updatedUser=userRepository.save(existUser);
		  return updatedUser; 
  }
  
  public UserDto createUser(UserDto userDto) {
	
//	  Set<SupplierSite> siteset=new HashSet<SupplierSite>();
//	  Set<Modules> moduleset=new HashSet<Modules>();
//	  int id1=userDto.getUserid();
//	  SupplierSite site=supplierRepo.getById(id1);
//	  siteset.add(site);
//	  
//	  int id2=userDto.getIduser();
//	  Modules modules=moduleRepo.getById(id2);
//	  moduleset.add(modules);
	 

	  
	  User user=new User(userDto.getSupplierName(),
			  userDto.getEmail(),
			  userDto.getMobile());
		
	  User  saveduser=userRepository.save(user);

		     UserDto saveduserDto=new UserDto(saveduser.getSupplierName(),
		    		 saveduser.getEmail(),
		    		 saveduser.getMobile());
		   
		     return saveduserDto;
		
	}
 
  public List<User> listAll() {
		return userRepository.findAll();
	}
  
  public String deleteUser(String username) {
	  User existUser=userRepository.findBySupplierName(username).get();
	  if(existUser==null) {
		  new UsernameNotFoundException("Username not Found");
	  } 
	  userRepository.delete(existUser);
			return "User deleted successfully !!";
	}
  
  public static String alphaNumericString(int len) {
	    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random rnd = new Random();

	    StringBuilder sb = new StringBuilder(len);
	    for (int i = 0; i < len; i++) {
	        sb.append(AB.charAt(rnd.nextInt(AB.length())));
	    }
	    System.out.println(sb.toString());
	    return sb.toString();
	}
  
  public static String decodePassword(String password) {
  byte[] decodedBytes = Base64.getDecoder().decode(password);
  String decodedString = new String(decodedBytes);
  return decodedString;
  }



  
  
}
