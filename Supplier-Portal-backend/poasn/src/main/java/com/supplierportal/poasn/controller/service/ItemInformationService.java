package com.supplierportal.poasn.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.entity.ItemInformation;


public interface ItemInformationService {
	ItemInformationDto createItemInformation(ItemInformationDto iteminfoDto); 
	
	List<ItemInformation> findAlliteminfo();
}
