package com.bezkoder.spring.login.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Iterator;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.models.ERole;
import com.bezkoder.spring.login.models.EmailDetails;
import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.models.User;
//import com.bezkoder.spring.login.models.AdminUser;
import com.bezkoder.spring.login.payload.request.LoginRequest;
//import com.bezkoder.spring.login.payload.request.NewUserRequest;
import com.bezkoder.spring.login.payload.request.SignupRequest;
import com.bezkoder.spring.login.payload.response.JwtResponse;
import com.bezkoder.spring.login.payload.response.MessageResponse;
//import com.bezkoder.spring.login.repository.AdminUserRepository;
import com.bezkoder.spring.login.repository.RoleRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import com.bezkoder.spring.login.security.jwt.JwtUtils;
import com.bezkoder.spring.login.security.services.EmailService;
import com.bezkoder.spring.login.security.services.UserDetailsImpl;
import com.bezkoder.spring.login.security.services.UserDetailsServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

//  @Autowired
//  AdminUserRepository adminuserRepository;
  
  @Autowired
  RoleRepository roleRepository;

 @Autowired
 PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired 
  private EmailService emailService;
  
  @Autowired 
  private UserDetailsServiceImpl userService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getSupplierName(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getSupplierId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         userDetails.getLandline(),
                         userDetails.getMobile(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsBySupplierName(signUpRequest.getSupplierName())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getSupplierName(), 
               signUpRequest.getEmail(),
               signUpRequest.getLandline(),
               signUpRequest.getMobile(),
               encoder.encode(UserDetailsServiceImpl.alphaNumericString(10)));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
       
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
 
//  -------------------------------------------****----------------------------------------------------------------
  
//  @PostMapping("/createUser")
//  public ResponseEntity<?> createUser(@Valid @RequestBody NewUserRequest newuserRequest) {
//	  if (adminuserRepository.existsByUsername(newuserRequest.getUsername())) {
//	      return ResponseEntity
//	          .badRequest()
//	          .body(new MessageResponse("Error: Username is already taken!"));
//	    }
//	  AdminUser user = new AdminUser(newuserRequest.getUsername(), 
//			  newuserRequest.getEmail(),
//			  newuserRequest.getMobile(),
//			  newuserRequest.getModule());
//	  
//	  adminuserRepository.save(user);
//	  return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//  }
  
  
  // Sending a simple Email
  @PostMapping("/sendMail/{supplierName}")
  public String sendMail(@PathVariable("supplierName") String supplierName)
  {
      String status = emailService.sendSimpleMail(supplierName);
      return status;
  }
  
  //update Password after logging in
  @PutMapping("updatePassword/{supplierName}")
  public String updatePassword(@RequestBody User user, @PathVariable String supplierName) {
 
      	User exist = userRepository.findBySupplierName(supplierName).get();
      	exist.setPassword(user.getPassword());
      	userRepository.save(exist);
      	String newPass=exist.getPassword();
      	return newPass;
      	}
  
  
//  @PutMapping("updateUser/{supplierName}")
//  public ResponseEntity<AdminUser> updateUserInfo(@RequestBody AdminUser user, @PathVariable String name) {
//	  AdminUser newUser=userService.EditUser(name,user);
//	  return new ResponseEntity<>(newUser,HttpStatus.OK);	
//  }
//  
//  @DeleteMapping("delete/{supplierName}")
//  public String userDelete(@PathVariable String name) {
//  	return userService.deleteUser(name);
//  }
//  
//  @GetMapping("viewlist")
//  public ResponseEntity<List<AdminUser>> displayallUsers(){
//		List<AdminUser> allUser=userService.listAll();
//		return new ResponseEntity<>(allUser,HttpStatus.CREATED);   
// }
  
}