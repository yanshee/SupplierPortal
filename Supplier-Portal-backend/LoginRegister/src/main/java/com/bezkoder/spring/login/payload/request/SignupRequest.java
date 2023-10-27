package com.bezkoder.spring.login.payload.request;

import java.util.Set;
import jakarta.validation.constraints.*;
 
public class SignupRequest {

    private String supplierName;
    @Email
    private String email;
    private String landline;
    private String mobile;
    //private String password;
    private Set<String> role;
    
  
   
 
    public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
//    public String getPassword() {
//        return password;
//    }
// 
//    public void setPassword(String password) {
//        this.password = password;
//    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

	
    
    
}
