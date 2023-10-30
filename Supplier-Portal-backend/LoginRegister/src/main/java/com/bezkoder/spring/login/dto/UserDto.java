package com.bezkoder.spring.login.dto;

import jakarta.validation.constraints.Email;

public class UserDto {
	  private String supplierName;
	  @Email
	  private String email;
	  private String mobile;
	 
	  private int userid;
	  private int iduser;

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public UserDto(String supplierName, @Email String email, String mobile, int userid, int iduser) {
		super();
		this.supplierName = supplierName;
		this.email = email;
		this.mobile = mobile;
		this.userid = userid;
		this.iduser=iduser;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
