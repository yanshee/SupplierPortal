package com.bezkoder.spring.login.payload.response;

import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private int id;
  private String supplierName;
  private String email;
  private String landline;
  private String mobile;
  private List<String> roles;

  public JwtResponse(String accessToken, int id, String supplierName, String email, String landline,
		  String mobile,List<String> roles) {
    this.token = accessToken;
    this.id= id;
    this.supplierName = supplierName;
    this.email = email;
    this.landline=landline;
    this.mobile=mobile;
    this.roles = roles;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  

 
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

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

public List<String> getRoles() {
    return roles;
  }
}