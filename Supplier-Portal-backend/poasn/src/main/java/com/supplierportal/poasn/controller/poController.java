package com.supplierportal.poasn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.Dto.poItemDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.entity.poItem;
import com.supplierportal.poasn.repository.poItemRepository;
import com.supplierportal.poasn.service.AsnInformationService;
import com.supplierportal.poasn.service.AsnService;
import com.supplierportal.poasn.service.ItemInformationService;
import com.supplierportal.poasn.service.pOrderService;
import com.supplierportal.poasn.service.poItemService;


@RestController
@RequestMapping("/porder")
public class poController {
	
	@Autowired
	private pOrderService porderService;
	
	@Autowired
	private ItemInformationService iteminfoService;
	
	@Autowired
	private poItemService poitemService;
	
	@Autowired
	private AsnService asnService;
	
	@Autowired
	private AsnInformationService asninfoservice;
	
	@Autowired
	private ItemInformationService iteminfoservice;
	
	@Autowired
	private poItemRepository poitemrepo;
	
	
	
	@PostMapping("/createpo")
	public ResponseEntity<pOrderDto> createUser(@RequestBody pOrderDto purchase){
		pOrderDto savedPO=porderService.createPurchaseOrder(purchase);
		return new ResponseEntity<>(savedPO,HttpStatus.CREATED);	
	}

		
	@GetMapping("sort/{field}")
	private ResponseEntity<List<pOrder>> getPurchaseOrderWithSort(@PathVariable String field){
		List<pOrder> allPurchaseOrders=porderService.findPurchaseOrderWithSorting(field);
		return new ResponseEntity<>(allPurchaseOrders,HttpStatus.CREATED);
	}
	
	@GetMapping("/searchpo/{poId}")
    public ResponseEntity<pOrder> searchProduct(@PathVariable("poId") Long poId){
        return ResponseEntity.ok(porderService.searchById(poId));      
   }
	
//	@GetMapping("/filter")
//    public ResponseEntity<List<purchaseOrder>> filterProducts(@RequestParam("query") String query){
//        return ResponseEntity.ok(purchaseorderService.filterProducts(query));      
//   }
	
	@GetMapping("/display/po")
    public ResponseEntity<List<pOrder>> displayallPO(){
		List<pOrder> allPO=porderService.listAll();
		return new ResponseEntity<>(allPO,HttpStatus.CREATED);   
   }
	
//------------------------------------------------********-------------------------------------------------------
	
	@PostMapping("/createItemInfo")
	public ResponseEntity<ItemInformationDto> createItemInfo(@RequestBody ItemInformationDto iteminfo){
		ItemInformationDto savedinfo=iteminfoService.createItemInformation(iteminfo);
		return new ResponseEntity<>(savedinfo,HttpStatus.CREATED);	
	}
	
	@PutMapping("updateiteminfo/{id}")
	 public ResponseEntity<ItemInformation> updateItemInfo(@RequestBody ItemInformation item, @PathVariable Integer id) {
		ItemInformation newItem=iteminfoservice.EditItem(id, item);
		return new ResponseEntity<>(newItem,HttpStatus.OK);	
	  }
	
	@PutMapping("/updateMultipleItems")
	public ResponseEntity<List<ItemInformation>> updateMultipleItemsByitemId(@RequestBody List<ItemInformation> items) {
		List<ItemInformation> newItem=iteminfoservice.updateItemsById(items);
		return new ResponseEntity<>(newItem, HttpStatus.OK);	
	}
	 
	 
	 @DeleteMapping("deleteAll/{ids}")
	    public void DeleteAll(@PathVariable  List<Integer> ids){
	        for (Integer id : ids) {
	        	iteminfoservice.remove(id);
	        	  
	        }
	 }
	 
	@GetMapping("/display/iteminfo")
    public ResponseEntity<List<ItemInformation>> displayallItems(){
		List<ItemInformation> allItems=iteminfoservice.findAll();
		return new ResponseEntity<>(allItems,HttpStatus.CREATED);   
   }
	
	 @DeleteMapping("delete/{id}")
    public void deleteItemInfo(@PathVariable Integer id){
		 iteminfoservice.remove(id);
    }
	 
	 @PutMapping("updateprice/{id}")
	 public ResponseEntity<ItemInformation> updateItemPrice(@RequestBody ItemInformation updatedInfo, @PathVariable Integer id) {
		ItemInformation newItem=iteminfoservice.newpriceById(id, updatedInfo);
		return new ResponseEntity<>(newItem,HttpStatus.OK);	
	  }
	 
	 @PutMapping("updateBulkprice/{ids}")
	 public ResponseEntity<List<ItemInformation>> updateBulkItemPrice(@RequestBody List<ItemInformation> updatedInfo, @PathVariable  List<Integer> ids) {
		 List<ItemInformation> newItemList= iteminfoservice.updateNewprice(ids, updatedInfo);
		return new ResponseEntity<>(newItemList,HttpStatus.OK);	
	  }
	  
//------------------------------------------------********-------------------------------------------------------

	@PostMapping("/createItem")
	public ResponseEntity<poItemDto> createPoItem(@RequestBody poItemDto itemdto){
		poItemDto savedpoitem=poitemService.createPoItem(itemdto);
		return new ResponseEntity<>(savedpoitem,HttpStatus.CREATED);	
	}
	
	@GetMapping("/display/poitem")
    public ResponseEntity<List<poItem>> displayallpoItem(){
		List<poItem> allpoItem=poitemService.findAllpoitem();
		return new ResponseEntity<>(allpoItem,HttpStatus.CREATED);   
   }
	
//------------------------------------------------********-------------------------------------------------------
}