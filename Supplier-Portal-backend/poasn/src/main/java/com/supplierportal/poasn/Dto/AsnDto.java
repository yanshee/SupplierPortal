package com.supplierportal.poasn.Dto;




public class AsnDto {
	
	private Long id;
	private Integer asnCount;
	private Integer containerCount;
	private String containerDetails;
	private Long poId;

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
	public String getContainerDetails() {
		return containerDetails;
	}

	public void setContainerDetails(String containerDetails) {
		this.containerDetails = containerDetails;
	}

	public Long getPoId() {
		return poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}

	public AsnDto(Long id, Integer asnCount, Integer containerCount, String containerDetails, Long poId) {
		super();
		this.id = id;
		this.asnCount = asnCount;
		this.containerCount = containerCount;
		this.containerDetails = containerDetails;
		this.poId = poId;
	}

	public AsnDto() {
		super();
		// TODO Auto-generated constructor stub
	}


}
