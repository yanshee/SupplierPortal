package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.supplierportal.poasn.Dto.AsnAlertDto;
import com.supplierportal.poasn.Dto.POAlertDto;
import com.supplierportal.poasn.entity.AsnAlert;
import com.supplierportal.poasn.repository.AsnAlertRepository;
import com.supplierportal.poasn.repository.POAlertRepository;
import com.supplierportal.poasn.service.POAlertService;
import com.supplierportal.poasn.entity.POAlert;

public class POAlertServiceImpl implements POAlertService{

	@Autowired
	private POAlertRepository poalertrepo;

	@Override
	public POAlertDto createPOAlert(POAlertDto poalertDto) {
		POAlert poalert=new POAlert(poalertDto.getAlertId(),
				poalertDto.getMessage(),
				poalertDto.getCreationDate());
		
		  POAlert savedpoalert=poalertrepo.save(poalert);

		     POAlertDto savedPOAlertDto=new POAlertDto(savedpoalert.getAlertId(),
		    		 savedpoalert.getMessage(),
		    		 savedpoalert.getCreationDate());
		   
		     return savedPOAlertDto;	
	}

	@Override
	public List<POAlert> listAllPO() {
		return poalertrepo.findAll();
	}

}
