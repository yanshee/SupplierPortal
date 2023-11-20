package com.bezkoder.spring.login.models;

import java.util.HashSet;


import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "email")
       })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;
  private String supplierName;
  @Email
  private String email;
  private String landline;
  private String mobile;
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "supplier_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  
  @OneToMany(mappedBy="user")
  private Set<SupplierSite> site;
	
  @OneToMany(mappedBy="users")
  private Set<Modules> module;
  
 
	


	public User(String supplierName, @Email String email, String mobile) {
	super();
	this.supplierName = supplierName;
	this.email = email;
	this.mobile = mobile;
//	this.site = site;
//	this.module = module;
}



	public User(String supplierName, @Email String email, String landline, String mobile, String password) {
		super();
		this.supplierName = supplierName;
		this.email = email;
		this.landline = landline;
		this.mobile = mobile;
		this.password = password;
	}
	
	

public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}

public String getLandline() {
	return landline;
}

public void setLandline(String landline) {
	this.landline = landline;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  

public Set<SupplierSite> getSite() {
	return site;
}

public void setSite(Set<SupplierSite> site) {
	this.site = site;
}

public Set<Modules> getModule() {
	return module;
}

public void setModule(Set<Modules> module) {
	this.module = module;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
