package com.supplierportal.poasn.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.entity.poItem;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.repository.ItemInformationRepository;
import com.supplierportal.poasn.repository.poItemRepository;
import com.supplierportal.poasn.service.ItemInformationService;

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
		
		
		ItemInformation info=new ItemInformation(iteminfoDto.getId(),
				iteminfoDto.getSpecification(),
				iteminfoDto.getProcessorName(),
				iteminfoDto.getItemBarcode(),
				iteminfoDto.getSku(),
				iteminfoDto.getPrice(),
				iteminfoDto.getCategory(),
				iteminfoDto.getStatus(),
				poobj);

		     ItemInformation savedinfo=iteminforepo.save(info);
		     long b= poobj.getItemid();
		//convert JPA entity to  DTO
		     ItemInformationDto savedinfoDto=new ItemInformationDto(savedinfo.getId(),
		    		 savedinfo.getSpecification(),
		    		 savedinfo.getProcessorName(),
		    		 savedinfo.getItemBarcode(),
		    		 savedinfo.getSku(),
		    		 savedinfo.getPrice(),
		    		 savedinfo.getCategory(),
		    		 savedinfo.getStatus(),
		    		 b);
		    
		     return savedinfoDto;
	}
	
	
	@Override
	 public void remove(Integer id ){
		iteminforepo.deleteById(id);
	 }
	
	
	@Override
	public List<ItemInformation> findAll(){
       return iteminforepo.findAll();
     }
	
	
	@Override
	public ItemInformation EditItem(Integer id, ItemInformation item) {
		ItemInformation existItem=iteminforepo.searchById(id);
		existItem.setSpecification(item.getSpecification());
		existItem.setProcessorName(item.getProcessorName());
		existItem.setItemBarcode(item.getItemBarcode());
		existItem.setSku(item.getSku());
		existItem.setPrice(item.getPrice());
		existItem.setCategory(item.getCategory());
		existItem.setStatus(item.getStatus());
		ItemInformation updatedItem=iteminforepo.save(existItem);
		  return updatedItem; 
     }
	
	
	@Override
	  public List<ItemInformation> updateItemsById(List<ItemInformation> items) 
	 {
		List<ItemInformation> itemsList=new ArrayList<>();
	 for (ItemInformation item : items) {
		 System.out.print(item);
   	     System.out.print(itemsList);
   	     int existId=item.getId();
		 System.out.print(existId);
		 ItemInformation existItem=iteminforepo.searchById(existId);
		 existItem.setSpecification(item.getSpecification());
		 existItem.setSku(item.getSku());
		 existItem.setCategory(item.getCategory());
		 existItem.setStatus(item.getStatus());
		 ItemInformation updatedItem=iteminforepo.save(existItem);
		 itemsList.add(updatedItem);
	  }
	   return itemsList ;
	  }
	
	
	@Override
	  public ItemInformation newpriceById(Integer id,ItemInformation updateInfo) 
	 {
		ItemInformation existItem=iteminforepo.findById(id).get();
		existItem.setNewPrice(updateInfo.getNewPrice());
		iteminforepo.save(existItem);
		return existItem;
	  }
	
	@Override
	  public List<ItemInformation> updateNewprice(List<Integer> ids, List<ItemInformation> items) 
	 {
		List<ItemInformation> itemsList=new ArrayList<>();
	    for (int i=0;i<ids.size();i++) {
	     Integer id=ids.get(i);
		 ItemInformation existItem=iteminforepo.searchById(id);
		 existItem.setNewPrice((items.get(i)).getNewPrice());
		 ItemInformation updatedItem=iteminforepo.save(existItem);
		 itemsList.add(updatedItem);
	  }
	   return itemsList ;
	  }

	}

