package com.bezkoder.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.UserRepository;
import java.util.Base64;
import java.util.List;
import java.util.Random;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  

  
  

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
		  existUser.setLandline(user.getLandline());
		  existUser.setMobile(user.getMobile());
		  User updatedUser=userRepository.save(existUser);
		  return updatedUser; 
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
