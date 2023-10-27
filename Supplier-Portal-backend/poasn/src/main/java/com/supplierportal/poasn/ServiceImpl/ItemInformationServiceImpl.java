package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.controller.service.ItemInformationService;
import com.supplierportal.poasn.entity.poItem;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.repository.ItemInformationRepository;
import com.supplierportal.poasn.repository.poItemRepository;

@Service
public class ItemInformationServiceImpl implements ItemInformationService {
	
	@Autowired
	private ItemInformationRepository iteminforepo;
	
	@Autowired
	private poItemRepository poitemrepo;

	@Override
	public ItemInformationDto createItemInformation(ItemInformationDto iteminfoDto) {
		long a= iteminfoDto.getItemid();
		poItem poobj=poitemrepo.searchByItemid(a);
		System.out.println("id" +a);
		
		ItemInformation info=new ItemInformation(iteminfoDto.getId(),
				iteminfoDto.getSpecification(),
				iteminfoDto.getProcessorName(),
				iteminfoDto.getItemBarcode(),
				poobj);

		     ItemInformation savedinfo=iteminforepo.save(info);

		//convert JPA entity to  DTO
		     ItemInformationDto savedinfoDto=new ItemInformationDto(savedinfo.getId(),
		    		 savedinfo.getSpecification(),
		    		 savedinfo.getProcessorName(),
		    		 savedinfo.getItemBarcode(),
		    		 a);
		    
		     return savedinfoDto;
	}

	@Override
	public List<ItemInformation> findAlliteminfo() {
		// TODO Auto-generated method stub
		return iteminforepo.findAll();
	}
	}

