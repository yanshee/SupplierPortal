package com.supplierportal.poasn.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AsnInformationDto {
	
	private Integer serialid;
	private String asnNumber;
	private Integer totalItems;
	private Integer shippedQty;
	private Integer deliveredQty;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date shippingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date eta;
	private String dcNumber;
	private String location;
	
	private Long id;


	
	public String getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(Integer shippedQty) {
		this.shippedQty = shippedQty;
	}

	public Integer getDeliveredQty() {
		return deliveredQty;
	}

	public void setDeliveredQty(Integer deliveredQty) {
		this.deliveredQty = deliveredQty;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public String getDcNumber() {
		return dcNumber;
	}

	public void setDcNumber(String dcNumber) {
		this.dcNumber = dcNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public Integer getSerialid() {
		return serialid;
	}

	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public AsnInformationDto(Integer serialid, String asnNumber, Integer totalItems, Integer shippedQty,
			Integer deliveredQty, Date creationDate, Date shippingDate, Date eta, String dcNumber, String location,
			Long id) {
		super();
		this.serialid = serialid;
		this.asnNumber = asnNumber;
		this.totalItems = totalItems;
		this.shippedQty = shippedQty;
		this.deliveredQty = deliveredQty;
		this.creationDate = creationDate;
		this.shippingDate = shippingDate;
		this.eta = eta;
		this.dcNumber = dcNumber;
		this.location = location;
		this.id = id;
	}

	public AsnInformationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
