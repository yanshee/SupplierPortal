package com.supplierportal.poasn.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String specification;
	private String processorName;
	private String itemBarcode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid", referencedColumnName="itemid")
	private poItem item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getProcessorName() {
		return processorName;
	}

	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	public String getItemBarcode() {
		return itemBarcode;
	}

	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}

	public poItem getItem() {
		return item;
	}

	public void setItem(poItem item) {
		this.item = item;
	}

	public ItemInformation(Integer id, String specification, String processorName, String itemBarcode, poItem item) {
		super();
		this.id = id;
		this.specification = specification;
		this.processorName = processorName;
		this.itemBarcode = itemBarcode;
		this.item = item;
	}

	public ItemInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
