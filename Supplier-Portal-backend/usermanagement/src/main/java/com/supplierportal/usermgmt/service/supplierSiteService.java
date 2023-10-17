package com.supplierportal.usermgmt.service;

import java.util.List;


import com.supplierportal.usermgmt.dto.supplierSiteDto;
import com.supplierportal.usermgmt.entity.supplierSite;
import org.springframework.stereotype.Service;

@Service
public interface supplierSiteService {

	supplierSiteDto createSupplierSite(supplierSiteDto suppliersiteDto); 
	List<supplierSite> listAll();
	supplierSite searchByName(String siteName);
}
