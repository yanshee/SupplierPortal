package com.supplierportal.po.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class asnNumberInfoDto {

	private int id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	private String dcNumber;
	private int totalItems;
	private int shippingQty;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date shippingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date eta;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getDcNumber() {
		return dcNumber;
	}
	public void setDcNumber(String dcNumber) {
		this.dcNumber = dcNumber;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getShippingQty() {
		return shippingQty;
	}
	public void setShippingQty(int shippingQty) {
		this.shippingQty = shippingQty;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public asnNumberInfoDto(int id, Date creationDate, String dcNumber, int totalItems, int shippingQty, Date shippingDate,
			Date eta, String location) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.dcNumber = dcNumber;
		this.totalItems = totalItems;
		this.shippingQty = shippingQty;
		this.shippingDate = shippingDate;
		this.eta = eta;
		this.location = location;
	}
	public asnNumberInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
