package com.supplierportal.poasn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.poasn.Dto.AsnAlertDto;
import com.supplierportal.poasn.Dto.AsnDto;
import com.supplierportal.poasn.Dto.AsnInformationDto;
import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.AsnInformation;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.service.AsnAlertService;
import com.supplierportal.poasn.service.AsnInformationService;
import com.supplierportal.poasn.service.AsnService;

@RestController
@RequestMapping("/asn")
public class asnController {
	
	@Autowired
	private AsnInformationService asninfoservice;
	
	@Autowired
	private AsnService asnservice;
	
	@Autowired
	private AsnAlertService asnalertservice;
	
	@PostMapping("/createasninfo")
	public ResponseEntity<AsnInformationDto> createAsnInfo(@RequestBody AsnInformationDto asninfo){
		AsnInformationDto savedasninfo=asninfoservice.createPurchaseOrder(asninfo);
		return new ResponseEntity<>(savedasninfo,HttpStatus.CREATED);	
	}
	@GetMapping("/display/asninfo")
    public ResponseEntity<List<AsnInformation>> displayallAsnInfo(){
		List<AsnInformation> allasnInfo=asninfoservice.listAllasninfo();
		return new ResponseEntity<>(allasnInfo,HttpStatus.CREATED);   
   }

	
//------------------------------------------------------*******------------------------------------------------------
	
	@PostMapping("/createasn")
	public ResponseEntity<AsnDto> createAsn(@RequestBody AsnDto asn){
		AsnDto savedasn=asnservice.createAsn(asn);
		return new ResponseEntity<>(savedasn,HttpStatus.CREATED);	
	}
	
	@GetMapping("/display/asn")
    public ResponseEntity<List<Asn>> displayallASN(){
		List<Asn> allasn=asnservice.listAllAsn();
		return new ResponseEntity<>(allasn,HttpStatus.CREATED);   
   }

	
//------------------------------------------------------*******------------------------------------------------------
	
	@PostMapping("/createasnalert")
	public ResponseEntity<AsnAlertDto> createAsnAlert(@RequestBody AsnAlertDto asn){
		AsnAlertDto savedasnalert=asnalertservice.createAsnAlert(asn);
		return new ResponseEntity<>(savedasnalert,HttpStatus.CREATED);	
	}
}
