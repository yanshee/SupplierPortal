package com.supplierportal.po.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supplierportal.po.dto.asnNumberInfoDto;
import com.supplierportal.po.entity.asnNumberInfo;
import com.supplierportal.po.repository.asnNumberRepository;

@Service
public class asnNumberService {
	
	@Autowired
	private asnNumberRepository asnnumberRepository;
	
	
	public List<asnNumberInfo> listAll() {
		return asnnumberRepository.findAll();
	}
	
	
	public asnNumberInfoDto createasnInfo(asnNumberInfoDto asnnumberdto) {
		asnNumberInfo asn=new asnNumberInfo(asnnumberdto.getId(), 
				asnnumberdto.getCreationDate(),
				asnnumberdto.getDcNumber(),
				asnnumberdto.getTotalItems(),
				asnnumberdto.getShippingQty(),
				asnnumberdto.getShippingDate(),
				asnnumberdto.getEta(),
				asnnumberdto.getLocation());

		     asnNumberInfo savedasn=asnnumberRepository.save(asn);

		//convert JPA entity to  DTO
		     asnNumberInfoDto savedasnDto=new asnNumberInfoDto(savedasn.getId(),
		    		 savedasn.getCreationDate(),
		    		 savedasn.getDcNumber(),
		    		 savedasn.getTotalItems(),
		    		 savedasn.getShippingQty(),
		    		 savedasn.getShippingDate(),
		    		 savedasn.getEta(),
		    		 savedasn.getLocation());
		    
		     return savedasnDto;
	}
}
