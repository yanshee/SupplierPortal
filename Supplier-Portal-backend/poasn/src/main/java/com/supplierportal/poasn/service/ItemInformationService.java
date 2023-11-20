package com.supplierportal.poasn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.ItemInformation;


public interface ItemInformationService {
	ItemInformationDto createItemInformation(ItemInformationDto iteminfoDto); 
	
//	List<ItemInformation> findAlliteminfo();

//	String deleteItem(String itemBarcode);

	ItemInformation EditItem(Integer id, ItemInformation item);

//	String deleteAllItem(Integer id);

	List<ItemInformation> updateItemsById(List<ItemInformation> items);

	void remove(Integer id);

	List<ItemInformation> findAll();
	
	ItemInformation newpriceById(Integer id,ItemInformation updatedInfo);

	public List<ItemInformation> updateNewprice(List<Integer> ids, List<ItemInformation> updateitems);
	
}
