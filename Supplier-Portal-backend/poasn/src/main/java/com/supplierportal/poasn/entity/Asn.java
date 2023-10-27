package com.supplierportal.poasn.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Asn {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer asnCount;
	private Integer containerCount;
//	private String asnDetails;
	private String containerDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="po_id",referencedColumnName="poId")
	private pOrder pobj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Integer getAsnCount() {
		return asnCount;
	}

	public void setAsnCount(Integer asnCount) {
		this.asnCount = asnCount;
	}

	public Integer getContainerCount() {
		return containerCount;
	}

	public void setContainerCount(Integer containerCount) {
		this.containerCount = containerCount;
	}

//	public String getAsnDetails() {
//		return asnDetails;
//	}
//
//	public void setAsnDetails(String asnDetails) {
//		this.asnDetails = asnDetails;
//	}

	public String getContainerDetails() {
		return containerDetails;
	}

	public void setContainerDetails(String containerDetails) {
		this.containerDetails = containerDetails;
	}
	
	public Asn(Long id, Integer asnCount, Integer containerCount, String containerDetails, pOrder pobj) {
		super();
		this.id = id;
		this.asnCount = asnCount;
		this.containerCount = containerCount;
		this.containerDetails = containerDetails;
		this.pobj = pobj;
	}

	public Asn() {
		super();
		// TODO Auto-generated constructor stub
	}


}
