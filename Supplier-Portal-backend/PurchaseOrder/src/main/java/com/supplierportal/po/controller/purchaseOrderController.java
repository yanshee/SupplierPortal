package com.supplierportal.po.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.po.dto.itemDetailsDto;
import com.supplierportal.po.dto.purchaseOrderDto;
import com.supplierportal.po.entity.purchaseOrder;
import com.supplierportal.po.service.itemDetailsService;
import com.supplierportal.po.service.purchaseOrderService;
import com.supplierportal.po.entity.*;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/purchaseorder")
public class purchaseOrderController{
	
	@Autowired
	private purchaseOrderService purchaseorderService;
	
	@Autowired
	private itemDetailsService itemdetailsService;
	
	//------> Purchase Order <-------
	@PostMapping("create")
	public ResponseEntity<purchaseOrderDto> createUser(@RequestBody purchaseOrderDto purchase){
		purchaseOrderDto savedPO=purchaseorderService.createPurchaseOrder(purchase);
		return new ResponseEntity<>(savedPO,HttpStatus.CREATED);	
	}

		
	@GetMapping("sort/{field}")
	private ResponseEntity<List<purchaseOrder>> getPurchaseOrderWithSort(@PathVariable String field){
		List<purchaseOrder> allPurchaseOrders=purchaseorderService.findPurchaseOrderWithSorting(field);
		return new ResponseEntity<>(allPurchaseOrders,HttpStatus.CREATED);
	}
	
	@GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=purchaseOrders_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<purchaseOrder> listPO = purchaseorderService.listAll();
         
        poExcelExporter excelExporter = new poExcelExporter(listPO);
         
        excelExporter.export(response);    
    }  
	
	
	
	@GetMapping("/searchpo/{poId}")
    public ResponseEntity<purchaseOrder> searchProduct(@PathVariable("poId") String poId){
        return ResponseEntity.ok(purchaseorderService.searchById(poId));      
   }
	
	@GetMapping("/filter")
    public ResponseEntity<List<purchaseOrder>> filterProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(purchaseorderService.filterProducts(query));      
   }
	
	@GetMapping("/display/po")
    public ResponseEntity<List<purchaseOrder>> displayallPO(){
		List<purchaseOrder> allPO=purchaseorderService.listAll();
		return new ResponseEntity<>(allPO,HttpStatus.CREATED);   
   }
	
	//----------> PO Summary <---------
	@GetMapping("/exportall")
    public void exportAllExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=PurchaseOrderExcel_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<purchaseOrder> listPurchaseOrders = purchaseorderService.listAll();
         
        poSummaryExport excelExporter = new poSummaryExport(listPurchaseOrders);
         
        excelExporter.export(response);    
    }  
	
	
	
	@PostMapping("create/item")
	public ResponseEntity<itemDetailsDto> createitem(@RequestBody itemDetailsDto item){
		itemDetailsDto saveditem=itemdetailsService.createitemDetails(item);
		return new ResponseEntity<>(saveditem,HttpStatus.CREATED);	
	}
	
	@GetMapping("/export/itemdetails")
    public void exportItemDetails(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ItemDetails_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<itemDetails> listItems = itemdetailsService.listAll();
         
        itemDetailsExport excelExporter = new itemDetailsExport(listItems);
         
        excelExporter.export(response);    
    }  
	
	@GetMapping("/display/items")
    public ResponseEntity<List<itemDetails>> displayallItems(){
		List<itemDetails> allitems=itemdetailsService.listAll();
		return new ResponseEntity<>(allitems,HttpStatus.CREATED);      
    }
	
//	@GetMapping("/searchitem/{itemId}")
//    public ResponseEntity<itemDetails> searchItem(@PathVariable("itemId") String itemId){
//        return ResponseEntity.ok(itemdetailsService.searchById(itemId));      
//   }
	
	
	
}
