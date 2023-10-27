package com.supplierportal.po.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supplierportal.po.dto.asnInfoDto;
import com.supplierportal.po.entity.asnInfo;
import com.supplierportal.po.repository.asnInfoRepository;


@Service
public class asnInfoService {
	
	@Autowired
	private asnInfoRepository asnRepo;
	

	public List<asnInfo> listallInfo() {
		return asnRepo.findAll();
				
	}
	
	
	public asnInfoDto createasnInfo(asnInfoDto asninfodto) {
		asnInfo asn=new asnInfo(asninfodto.getItemId(), 
				asninfodto.getItems(),
				asninfodto.getPoQty(),
				asninfodto.getDeliveredQty(),
				asninfodto.getShippedQty());

		     asnInfo savedasn=asnRepo.save(asn);

		//convert JPA entity to  DTO
		     asnInfoDto savedasnDto=new asnInfoDto(savedasn.getItemId(),
		    		 savedasn.getItems(),
		    		 savedasn.getPoQty(),
		    		 savedasn.getDeliveredQty(),
		    		 savedasn.getShippedQty());
		    
		     return savedasnDto;
	}
}


