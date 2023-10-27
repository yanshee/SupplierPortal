package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.supplierportal.poasn.Dto.AsnAlertDto;
import com.supplierportal.poasn.Dto.AsnDto;
import com.supplierportal.poasn.controller.service.AsnAlertService;
import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.AsnAlert;
import com.supplierportal.poasn.repository.AsnAlertRepository;

public class AsnAlertServiceImpl implements AsnAlertService{
	
	@Autowired
	private AsnAlertRepository asnalertrepo;

	@Override
	public AsnAlertDto createAsnAlert(AsnAlertDto asnalertDto) {
		AsnAlert asnalert=new AsnAlert(asnalertDto.getAlertId(),
				asnalertDto.getMessage(),
				asnalertDto.getCreationDate());
		
		  AsnAlert savedasnalert=asnalertrepo.save(asnalert);

		     AsnAlertDto savedAsnAlertDto=new AsnAlertDto(savedasnalert.getAlertId(),
		    		 savedasnalert.getMessage(),
		    		 savedasnalert.getCreationDate());
		   
		     return savedAsnAlertDto;
		
	}

	@Override
	public List<AsnAlert> listAllAsn() {
		return asnalertrepo.findAll();
	}

}
