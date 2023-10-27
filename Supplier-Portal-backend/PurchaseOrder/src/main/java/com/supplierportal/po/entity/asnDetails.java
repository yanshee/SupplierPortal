package com.supplierportal.po.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class asnDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int asnCount;
	private int containerCount;
	private String asnDetails;
	private String containerDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAsnCount() {
		return asnCount;
	}
	public void setAsnCount(int asnCount) {
		this.asnCount = asnCount;
	}
	public int getContainerCount() {
		return containerCount;
	}
	public void setContainerCount(int containerCount) {
		this.containerCount = containerCount;
	}
	public String getAsnDetails() {
		return asnDetails;
	}
	public void setAsnDetails(String asnDetails) {
		this.asnDetails = asnDetails;
	}
	public String getContainerDetails() {
		return containerDetails;
	}
	public void setContainerDetails(String containerDetails) {
		this.containerDetails = containerDetails;
	}
	
	public asnDetails(int id, int asnCount, int containerCount, String asnDetails, String containerDetails) {
		super();
		this.id=id;
		this.asnCount=asnCount;
		this.containerCount=containerCount;
		this.asnDetails=asnDetails;
		this.containerDetails=containerDetails;
		
		// TODO Auto-generated constructor stub
	}
	public asnDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
