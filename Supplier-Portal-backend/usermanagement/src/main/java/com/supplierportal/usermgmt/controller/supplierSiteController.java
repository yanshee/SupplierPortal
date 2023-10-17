package com.supplierportal.usermgmt.controller;

import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.supplierportal.usermgmt.dto.supplierSiteDto;
import com.supplierportal.usermgmt.entity.supplierSite;
import com.supplierportal.usermgmt.repository.supplierSiteRepository;
import com.supplierportal.usermgmt.serviceImpl.supplierSiteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/suppliersite")
public class supplierSiteController {
	
	
	@Autowired
	private supplierSiteServiceImpl supplierImpl;
	
	@Autowired
	private supplierSiteRepository supplierRepo;

	@PostMapping("create")
	public ResponseEntity<supplierSiteDto> createSite(@RequestBody supplierSiteDto site){
		supplierSiteDto savedsite=supplierImpl.createSupplierSite(site);
		return new ResponseEntity<>(savedsite,HttpStatus.CREATED);	
	}
	
	@GetMapping("/view")
    public ResponseEntity<List<supplierSite>> listAllSite(){
    	List<supplierSite> allSites=supplierImpl.listAll();
		return new ResponseEntity<>(allSites,HttpStatus.CREATED);   
       
   }
	
	@PutMapping("updateSite/{siteName}")
	 public ResponseEntity<supplierSite> updateSiteInfo(@RequestBody supplierSite site, @PathVariable String siteName) {
		supplierSite newSite=supplierImpl.EditSite(siteName , site);
		return new ResponseEntity<>(newSite,HttpStatus.OK);	
	  }
	
	  
	 @DeleteMapping("delete/{siteName}")
	    public String deleteSite(@PathVariable String siteName) {
	    	return supplierImpl.deleteSite(siteName);
	    }

}
