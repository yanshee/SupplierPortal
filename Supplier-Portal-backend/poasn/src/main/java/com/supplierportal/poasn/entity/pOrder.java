package com.supplierportal.poasn.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class pOrder {
	@Id
	private Long poId;
	private String location;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	private String poQty;
	private String totalItems;
	
	public Long getPoId() {
		return poId;
	}
	public void setPoId(Long poId) {
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
	
	
	
	public pOrder(Long poId, String location, Date creationDate, String poQty, String totalItems) {
		super();
		this.poId = poId;
		this.location = location;
		this.creationDate = creationDate;
		this.poQty = poQty;
		this.totalItems = totalItems;
	}
	
	public pOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
