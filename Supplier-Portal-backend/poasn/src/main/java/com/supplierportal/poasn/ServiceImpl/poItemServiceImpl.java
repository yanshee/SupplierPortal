package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.poItemDto;
import com.supplierportal.poasn.entity.AsnInformation;
import com.supplierportal.poasn.entity.poItem;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.repository.AsnInformationRepository;
import com.supplierportal.poasn.repository.pOrderRepository;
import com.supplierportal.poasn.repository.poItemRepository;
import com.supplierportal.poasn.service.poItemService;

@Service
public class poItemServiceImpl implements poItemService{
	
	@Autowired
	private pOrderRepository porepo;
	
	@Autowired
	private AsnInformationRepository asninforepo;
	
	@Autowired
	private poItemRepository poitemrepo;

	@Override
	public poItemDto createPoItem(poItemDto poitemdto) {
		
		Long a=poitemdto.getPoId();
		pOrder po= porepo.searchBypoId(a);
		
		Integer b=poitemdto.getSerialid();
		AsnInformation asninfo=asninforepo.searchBySerialid(b);
		
		poItem item=new poItem(poitemdto.getItemid(),
				poitemdto.getItemNumber(),
				poitemdto.getItemName(),
				poitemdto.getOrderedQty(),
				poitemdto.getShippedQty(),
				poitemdto.getOrderedQty(),
				poitemdto.getEstdLandingCost(),
				po,asninfo);

		     poItem saveditem= poitemrepo.save(item);

		     poItemDto savedinfoDto=new poItemDto(saveditem.getItemid(),
		    		 saveditem.getItemNumber(),
		    		 saveditem.getItemName(),
		    		 saveditem.getOrderedQty(),
		    		 saveditem.getShippedQty(),
		    		 saveditem.getDeliveredQty(),
		    		 saveditem.getEstdLandingCost(),
		    		 a,b);
		    
		     return savedinfoDto;
	}

	@Override
	public List<poItem> findAllpoitem() {
		// TODO Auto-generated method stub
		return poitemrepo.findAll();
	}

	
}
