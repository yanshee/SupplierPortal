package com.supplierportal.po.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.po.dto.asnDetailsDto;
import com.supplierportal.po.dto.asnInfoDto;
import com.supplierportal.po.dto.asnNumberInfoDto;
import com.supplierportal.po.entity.asnDetails;
import com.supplierportal.po.entity.asnDetailsExport;
import com.supplierportal.po.entity.asnInfo;
import com.supplierportal.po.service.asnDetailsService;
import com.supplierportal.po.service.asnInfoService;
import com.supplierportal.po.service.asnNumberService;
import com.supplierportal.po.entity.asnNumberInfo;
import com.supplierportal.po.entity.asnNumberInfoExporter;
import com.supplierportal.po.entity.asnInfoExporter;
import com.supplierportal.po.entity.itemDetails;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("http://localhost:3000/")
@RestController
public class asnDetailsController {
	
	@Autowired
	private asnDetailsService asndetailsService;
	
	@Autowired
	private asnNumberService asnnumberService;
	
	@Autowired
	private asnInfoService asninfoService;

	
	
	//------> For ASN Details <--------
	@PostMapping("create/asn")
	public ResponseEntity<asnDetailsDto> createasn(@RequestBody asnDetailsDto asn){
		asnDetailsDto savedasn=asndetailsService.createasnDetails(asn);
		return new ResponseEntity<>(savedasn,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/export/asndetails")
    public void exportItemDetails(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ItemDetails_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<asnDetails> listasn = asndetailsService.listAllAsn();
         
        asnDetailsExport excelExporter = new asnDetailsExport(listasn);
         
        excelExporter.export(response);    
    } 
	
	
	@GetMapping("/display/asndetails")
    public ResponseEntity<List<asnDetails>> displayAll(){
		List<asnDetails> all=asndetailsService.listAllAsn();
		return new ResponseEntity<>(all,HttpStatus.CREATED);      
    }
	
	//------> For ASN Number <--------
	@PostMapping("create/asnnumber")
	public ResponseEntity<asnNumberInfoDto> createasnNumber(@RequestBody asnNumberInfoDto asn){
		asnNumberInfoDto savedasn=asnnumberService.createasnInfo(asn);
		return new ResponseEntity<>(savedasn,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/export/asnnumber")
    public void asnNumberInfoExporter(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ASNNumber_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<asnNumberInfo> listasn = asnnumberService.listAll();
        asnNumberInfoExporter excelExporter = new asnNumberInfoExporter(listasn); 
        excelExporter.export(response);    
    } 
	
	@GetMapping("/display/asnnumber")
    public ResponseEntity<List<asnNumberInfo>> displayallNumber(){
		List<asnNumberInfo> allitems=asnnumberService.listAll();
		return new ResponseEntity<>(allitems,HttpStatus.CREATED);      
    }
	
	

	//------> for ASN INFO <--------
	
	@PostMapping("create/asninfo")
	public ResponseEntity<asnInfoDto> createasnInfo(@RequestBody asnInfoDto asn){
		asnInfoDto savedasn=asninfoService.createasnInfo(asn);
		return new ResponseEntity<>(savedasn,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/display/asninfo")
    public ResponseEntity<List<asnInfo>> displayallItems(){
		List<asnInfo> allitems=asninfoService.listallInfo();
		return new ResponseEntity<>(allitems,HttpStatus.CREATED);      
    }
	
	@GetMapping("/export/asninfo")
    public void asnInfoExporter(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ASNInfo_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<asnInfo> listasn = asninfoService.listallInfo();
        asnInfoExporter excelExporter = new asnInfoExporter(listasn); 
        excelExporter.export(response);    
    } 
	
	
	

}
