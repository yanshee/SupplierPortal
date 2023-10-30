package com.bezkoder.spring.login.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moduleId;
	private String moduleName;
	
//	@ManyToOne
//    @JoinColumn(name="id_user", nullable=false)
//    private User users;

	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Modules(int moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}
	public Modules() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
