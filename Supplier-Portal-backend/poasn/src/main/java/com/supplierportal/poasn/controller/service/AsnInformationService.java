package com.supplierportal.poasn.controller.service;

import java.util.List;

import com.supplierportal.poasn.Dto.AsnInformationDto;
import com.supplierportal.poasn.entity.AsnInformation;

public interface AsnInformationService {
	AsnInformationDto createPurchaseOrder(AsnInformationDto asninfoDto); 
	
	List<AsnInformation> listAllasninfo();
}
