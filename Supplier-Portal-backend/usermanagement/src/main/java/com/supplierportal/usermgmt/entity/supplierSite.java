package com.supplierportal.usermgmt.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class supplierSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String siteName;
	private String siteAddress;
	private String contact;
	private String landmark;
	private String longitude;
	private String latitude;
	private String sitecode;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getSitecode() {
		return sitecode;
	}
	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}
	public supplierSite(int id, String siteName, String siteAddress, String contact, String landmark, String longitude,
			String latitude, String sitecode) {
		super();
		this.id = id;
		this.siteName = siteName;
		this.siteAddress = siteAddress;
		this.contact = contact;
		this.landmark = landmark;
		this.longitude = longitude;
		this.latitude = latitude;
		this.sitecode = sitecode;
	}
	
	
	public supplierSite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
