package com.supplierportal.po.service;

import java.util.List;

import com.supplierportal.po.dto.itemDetailsDto;
import com.supplierportal.po.entity.itemDetails;
import com.supplierportal.po.entity.purchaseOrder;

public interface itemDetailsService {

	List<itemDetails> listAll();
	itemDetailsDto createitemDetails(itemDetailsDto itemdetailsDto);
//	itemDetails searchById(String itemId);
	

}
