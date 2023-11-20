package com.supplierportal.poasn.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class POAlertDto {
	private String alertId;
	private String message;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	
	
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public POAlertDto(String alertId, String message, Date creationDate) {
		super();
		this.alertId = alertId;
		this.message = message;
		this.creationDate = creationDate;
	}
	public POAlertDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
