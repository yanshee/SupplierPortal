package com.supplierportal.po.dto;

public class asnDetailsDto {
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
	public asnDetailsDto(int id, int asnCount, int containerCount, String asnDetails, String containerDetails) {
		super();
		this.id = id;
		this.asnCount = asnCount;
		this.containerCount = containerCount;
		this.asnDetails = asnDetails;
		this.containerDetails = containerDetails;
	}
	public asnDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
