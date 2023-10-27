package com.bezkoder.spring.login.payload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String supplierName;

	@NotBlank
	private String password;

	

	

//	public String getSupplierId() {
//		return supplierId;
//	}
//
//	public void setSupplierId(String supplierId) {
//		this.supplierId = supplierId;
//	}
	
	

	public String getPassword() {
		return password;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
