package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.AsnAlertDto;
import com.supplierportal.poasn.entity.AsnAlert;

public interface AsnAlertService {
	AsnAlertDto createAsnAlert(AsnAlertDto asnalertDto);
	
	List<AsnAlert> listAllAsn();
} 
