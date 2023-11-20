package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.AsnInformationDto;
import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.AsnInformation;
import com.supplierportal.poasn.repository.AsnInformationRepository;
import com.supplierportal.poasn.repository.AsnRepository;
import com.supplierportal.poasn.service.AsnInformationService;

@Service
public class AsnInformationServiceImpl implements AsnInformationService {
	
	@Autowired
	private AsnInformationRepository asninforepo;
	
	@Autowired
	private AsnRepository asnrepo;
	
	@Override
	public AsnInformationDto createPurchaseOrder(AsnInformationDto asninfoDto) {
		
		Long a= asninfoDto.getId();
		Asn asnobj=asnrepo.searchById(a);
		
		AsnInformation info=new AsnInformation(asninfoDto.getSerialid(),
				asninfoDto.getAsnNumber(),
				asninfoDto.getTotalItems(),
				asninfoDto.getShippedQty(),
				asninfoDto.getDeliveredQty(),
				asninfoDto.getCreationDate(),
				asninfoDto.getShippingDate(),
				asninfoDto.getEta(),
				asninfoDto.getDcNumber(),
				asninfoDto.getLocation(),
				asnobj);

		     AsnInformation savedasn=asninforepo.save(info);
		     Long b=asnobj.getId();

		//convert JPA entity to  DTO
		     AsnInformationDto savedasnDto=new AsnInformationDto(savedasn.getSerialid(),
		    		 savedasn.getAsnNumber(),
		    		 savedasn.getTotalItems(),
		    		 savedasn.getShippedQty(),
		    		 savedasn.getDeliveredQty(),
		    		 savedasn.getCreationDate(),
		    		 savedasn.getShippingDate(),
		    		 savedasn.getEta(),
		    		 savedasn.getDcNumber(),
		    		 savedasn.getLocation(),
		    		 b);
		    
		     return savedasnDto;
	}

	@Override
	public List<AsnInformation> listAllasninfo() {
		// TODO Auto-generated method stub
		return asninforepo.findAll();
	}
	
}
