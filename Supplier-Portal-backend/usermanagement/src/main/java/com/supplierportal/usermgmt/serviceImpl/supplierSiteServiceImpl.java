package com.supplierportal.usermgmt.serviceImpl;

import java.util.List;
import com.supplierportal.usermgmt.dto.supplierSiteDto;
import com.supplierportal.usermgmt.entity.supplierSite;
import com.supplierportal.usermgmt.repository.supplierSiteRepository;
import com.supplierportal.usermgmt.service.supplierSiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class supplierSiteServiceImpl implements supplierSiteService{
	
	@Autowired
	private supplierSiteRepository supplierRepo;
	

	@Override
	public supplierSiteDto createSupplierSite(supplierSiteDto suppliersiteDto) {
		supplierSite suppliersite=new supplierSite(suppliersiteDto.getId(), 
				suppliersiteDto.getSiteName(),
				suppliersiteDto.getSiteAddress(),
				suppliersiteDto.getContact(),
				suppliersiteDto.getLandmark(),
				suppliersiteDto.getLongitude(),
				suppliersiteDto.getLatitude(),
				suppliersiteDto.getSitecode());

		supplierSite savedsite= supplierRepo.save(suppliersite);

		//convert JPA entity to  DTO
		supplierSiteDto supplierDto=new supplierSiteDto(savedsite.getId(),
				savedsite.getSiteName(),
				savedsite.getSiteAddress(),
				savedsite.getContact(),
				savedsite.getLandmark(),
				savedsite.getLongitude(),
				savedsite.getLatitude(),
				savedsite.getSitecode());
		    
		     return supplierDto;
	}
	public supplierSite EditSite(String siteName, supplierSite site) {
	
			  supplierSite existSite=supplierRepo.findBySiteName(siteName);
			  existSite.setSiteName(site.getSiteName());
			  existSite.setSiteAddress(site.getSiteAddress());
			  existSite.setContact(site.getContact());
			  existSite.setLandmark(site.getLandmark());
			  existSite.setLatitude(site.getLatitude());
			  existSite.setLongitude(site.getLongitude());
			  existSite.setSitecode(site.getSitecode());
			  supplierSite updatedSite=supplierRepo.save(existSite);
			  return updatedSite; 
	}

	@Override
	public List<supplierSite> listAll() {
		// TODO Auto-generated method stub
		return supplierRepo.findAll();
	}

	@Override
	public supplierSite searchByName(String siteName) {
		return supplierRepo.findBySiteName(siteName);
	}
	
	
	public String deleteSite(String siteName) {
		supplierSite site=supplierRepo.findBySiteName(siteName);
		if(site==null) {
			  return "Supplier Site not Found !!";
		  } 
		supplierRepo.delete(site);;
				return "Supplier Site deleted successfully !!";
	}
}
