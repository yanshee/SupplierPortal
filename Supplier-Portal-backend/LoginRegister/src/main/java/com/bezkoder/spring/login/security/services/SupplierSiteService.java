package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.SupplierSite;
import com.bezkoder.spring.login.repository.SupplierSiteRepository;



@Service
public class SupplierSiteService {
	@Autowired
	private SupplierSiteRepository supplierRepo;
	
	public SupplierSite EditSite(String siteName, SupplierSite site) {
		
		  SupplierSite existSite=supplierRepo.findBySiteName(siteName);
		  existSite.setSiteName(site.getSiteName());
		  existSite.setSiteAddress(site.getSiteAddress());
		  existSite.setContact(site.getContact());
		  existSite.setLandmark(site.getLandmark());
		  existSite.setLatitude(site.getLatitude());
		  existSite.setLongitude(site.getLongitude());
		  existSite.setSitecode(site.getSitecode());
		  SupplierSite updatedSite=supplierRepo.save(existSite);
		  return updatedSite; 
}


public List<SupplierSite> listAll() {
	// TODO Auto-generated method stub
	return supplierRepo.findAll();
}


public SupplierSite searchByName(String siteName) {
	return supplierRepo.findBySiteName(siteName);
}


public String deleteSite(String siteName) {
	SupplierSite site=supplierRepo.findBySiteName(siteName);
	if(site==null) {
		  return "Supplier Site not Found !!";
	  } 
	supplierRepo.delete(site);;
			return "Supplier Site deleted successfully !!";
}
}
