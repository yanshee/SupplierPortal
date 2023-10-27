package com.supplierportal.po.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.po.dto.asnDetailsDto;
import com.supplierportal.po.dto.itemDetailsDto;
import com.supplierportal.po.entity.asnDetails;
import com.supplierportal.po.entity.itemDetails;
import com.supplierportal.po.repository.asnDetailsRepository;

@Service
public class asnDetailsService {

	@Autowired
	private asnDetailsRepository asndetailsRepository;
	
	public List<asnDetails> listAllAsn() {
		// TODO Auto-generated method stub
		return asndetailsRepository.findAll();
	}

	
	public asnDetailsDto createasnDetails(asnDetailsDto asndto) {
		asnDetails asn=new asnDetails(asndto.getId(), 
				asndto.getAsnCount(),
				asndto.getContainerCount(),
				asndto.getAsnDetails(),
				asndto.getContainerDetails());

		     asnDetails savedasn=asndetailsRepository.save(asn);

		//convert JPA entity to  DTO
		     asnDetailsDto savedasnDto=new asnDetailsDto(savedasn.getId(),
		    		 savedasn.getAsnCount(),
		    		 savedasn.getContainerCount(),
		    		 savedasn.getAsnDetails(),
		    		 savedasn.getContainerDetails());
		    
		     return savedasnDto;
	}
	
}
