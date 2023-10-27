package com.supplierportal.poasn.controller.service;

import java.util.List;
import com.supplierportal.poasn.Dto.poItemDto;
import com.supplierportal.poasn.entity.poItem;

public interface poItemService {
	
	poItemDto createPoItem(poItemDto poitemdto);
	
	List<poItem> findAllpoitem();
	
}
