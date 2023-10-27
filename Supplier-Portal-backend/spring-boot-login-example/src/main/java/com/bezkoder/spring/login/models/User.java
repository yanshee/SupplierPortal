package com.bezkoder.spring.login.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "supplierName"),
           @UniqueConstraint(columnNames = "email")
       })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotBlank
  @Size(max = 20)
  private String supplierName;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  @GeneratedValue(strategy=GenerationType.UUID)
  private String password;
  
  private String landline;
  
  private String mobileNo;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  

  public User(@NotBlank @Size(max = 20) String supplierName, @NotBlank @Size(max = 50) @Email String email,
		@NotBlank @Size(max = 120) String password, String landline, String mobileNo) {
	super();
	this.supplierName = supplierName;
	this.email = email;
	this.password = password;
	this.landline = landline;
	this.mobileNo = mobileNo;
//	this.roles = roles;
}



public String getId() {
    return id;
  }

  public void setId(String id) {
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



public String getMobileNo() {
	return mobileNo;
}



public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
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
}
