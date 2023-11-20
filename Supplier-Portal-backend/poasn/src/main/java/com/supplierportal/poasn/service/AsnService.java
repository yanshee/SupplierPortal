package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.AsnDto;
import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.entity.Asn;

public interface AsnService {
	AsnDto createAsn(AsnDto asnDto); 
	
	List<Asn> listAllAsn();
}
