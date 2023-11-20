package com.supplierportal.poasn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class POAlert {
	@Id
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
	public POAlert(String alertId, String message, Date creationDate) {
		super();
		this.alertId = alertId;
		this.message = message;
		this.creationDate = creationDate;
	}
	
	
	
}
