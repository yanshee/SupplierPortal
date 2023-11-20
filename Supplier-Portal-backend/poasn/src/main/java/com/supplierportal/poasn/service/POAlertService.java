package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.AsnAlertDto;
import com.supplierportal.poasn.Dto.POAlertDto;
import com.supplierportal.poasn.entity.POAlert;

public interface POAlertService {
	
	POAlertDto createPOAlert(POAlertDto poalertDto);
	
	List<POAlert> listAllPO();
}
