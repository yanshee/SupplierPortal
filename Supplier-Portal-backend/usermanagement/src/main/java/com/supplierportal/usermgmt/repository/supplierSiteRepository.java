package com.supplierportal.usermgmt.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supplierportal.usermgmt.entity.supplierSite;

public interface supplierSiteRepository extends JpaRepository<supplierSite, Integer>{

	//List<supplierSite> listAll();
	
//	@Query("SELECT siteName FROM supplierSite ss WHERE ss.siteName= :siteName") 
//	List<supplierSite> searchBysiteName(String siteName);
	
	supplierSite findBySiteName(String siteName);
	
	
}
