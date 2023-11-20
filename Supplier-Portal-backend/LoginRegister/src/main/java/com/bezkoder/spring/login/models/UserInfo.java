package com.bezkoder.spring.login.models;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "usersInfo")
public class UserInfo {
	 @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	  private Integer id;
//	  private String supplierName;
//	  @Email
//	  private String email;
//	  private String landline;
//	  private String mobile;
//	  private String password;
	  
	  @OneToMany(fetch = FetchType.LAZY)
	  @JoinColumn(name = "site_id12", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  private  Set<SupplierSite> site;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
//
//	public String getSupplierName() {
//		return supplierName;
//	}
//
//	public void setSupplierName(String supplierName) {
//		this.supplierName = supplierName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getLandline() {
//		return landline;
//	}
//
//	public void setLandline(String landline) {
//		this.landline = landline;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public Set<SupplierSite> getSite() {
		return site;
	}

	public void setSite(Set<SupplierSite> site) {
		this.site = site;
	}

	public UserInfo(Integer id, String supplierName, @Email String email, String landline, String mobile,
			String password, Set<SupplierSite> site) {
		super();
		this.id = id;
//		this.supplierName = supplierName;
//		this.email = email;
//		this.landline = landline;
//		this.mobile = mobile;
//		this.password = password;
		this.site = site;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  

}
