package com.supplierportal.poasn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.Dto.poItemDto;
import com.supplierportal.poasn.controller.service.AsnInformationService;
import com.supplierportal.poasn.controller.service.AsnService;
import com.supplierportal.poasn.controller.service.ItemInformationService;
import com.supplierportal.poasn.controller.service.pOrderService;
import com.supplierportal.poasn.controller.service.poItemService;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.entity.poItem;


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
	
	@GetMapping("/display/iteminfo")
    public ResponseEntity<List<ItemInformation>> displayallItemInfo(){
		List<ItemInformation> allItemInfo=iteminfoService.findAlliteminfo();
		return new ResponseEntity<>(allItemInfo,HttpStatus.CREATED);   
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
