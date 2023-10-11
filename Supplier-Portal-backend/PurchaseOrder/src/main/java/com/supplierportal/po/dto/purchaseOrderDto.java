package com.supplierportal.po.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class purchaseOrderDto {
	private int id;
	private String poId;
	private String location;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	private String poQty;
	private String totalItems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getPoQty() {
		return poQty;
	}
	public void setPoQty(String poQty) {
		this.poQty = poQty;
	}
	public String getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}
	public purchaseOrderDto(int id,String poId, String location, Date creationDate, String poQty, String totalItems) {
		super();
		this.id=id;
		this.poId = poId;
		this.location = location;
		this.creationDate = creationDate;
		this.poQty = poQty;
		this.totalItems = totalItems;
	}
	public purchaseOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
