package com.supplierportal.poasn.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.AsnDto;
import com.supplierportal.poasn.controller.service.AsnService;
import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.repository.AsnRepository;
import com.supplierportal.poasn.repository.pOrderRepository;

@Service
public class AsnServiceImpl implements AsnService {
	
	@Autowired
	private pOrderRepository poRepo;
	
	@Autowired
	private AsnRepository asnRepository;
	
//	Set<pOrder> po=new HashSet<pOrder>();
//	Set<Long> poIdset=new HashSet<Long>();
	
	@Override
	public AsnDto createAsn(AsnDto asnDto) {
//		Set<Long> poIdSet=asnDto.getPoIds();
//		Iterator<Long> poIterator=poIdSet.iterator();
//		while(poIterator.hasNext()) {
//			pOrder newpo=poRepository.searchBypoId(poIterator.next());
//			po.add(newpo);
//		}
		Long a=asnDto.getPoId();
		pOrder po= poRepo.searchBypoId(a);
		
		Asn asn=new Asn(asnDto.getId(),
				asnDto.getAsnCount(),
				asnDto.getContainerCount(),
				asnDto.getContainerDetails(),po);
		
		
//		Iterator<pOrder> newIterate=po.iterator();
//		while(newIterate.hasNext()) {
//			pOrder a=newIterate.next();
//			Long b=a.getPoId();
//			poIdset.add(b);
//		}

		     Asn savedasn=asnRepository.save(asn);

		     AsnDto savedAsnDto=new AsnDto(savedasn.getId(),
		    		 savedasn.getAsnCount(),
		    		 savedasn.getContainerCount(),
		    		 savedasn.getContainerDetails(),a);
		   
		     return savedAsnDto;
	}

	@Override
	public List<Asn> listAllAsn() {
		// TODO Auto-generated method stub
		return asnRepository.findAll();
	}

}
