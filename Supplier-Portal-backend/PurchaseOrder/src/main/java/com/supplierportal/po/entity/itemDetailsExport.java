package com.supplierportal.po.entity;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;


public class itemDetailsExport {
	private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<itemDetails> listItem;
	
	 
	 public itemDetailsExport(List<itemDetails> listItem) {
		 this.listItem=listItem;
	     workbook = new XSSFWorkbook();
	     sheet= workbook.createSheet("ItemDetailsExcel");
	}
	 
	 private void writeHeaderLine() {
	        
	        Row row = sheet.createRow(0);
	         
	       Cell cell=row.createCell(0);
	       cell.setCellValue("itemId");
	       
	        cell=row.createCell(1);
	       cell.setCellValue("itemName");
	       
	       cell=row.createCell(2);
	       cell.setCellValue("orderQty");
	       
	       cell=row.createCell(3);
	       cell.setCellValue("shipQty");
	       
	       cell=row.createCell(4);
	       cell.setCellValue("deliverQty");
	       
	       cell=row.createCell(5);
	       cell.setCellValue("estCost");
	               
	    }
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	                 
	        for (itemDetails items : listItem) {
	            XSSFRow row = sheet.createRow(rowCount++);
	            Cell cell=row.createCell(0);
	            cell.setCellValue(items.getItemId());
	            
	            cell=row.createCell(1);
	            cell.setCellValue(items.getItemName());
	            
	            cell=row.createCell(2);
	            cell.setCellValue(items.getOrderQty());
	            
	            cell=row.createCell(3);
	            cell.setCellValue(items.getShipQty());
	            
	            cell=row.createCell(4);
	            cell.setCellValue(items.getDeliverQty());
	            
	            cell=row.createCell(5);
	            cell.setCellValue(items.getEstCost());
	             
	           
	        }
	    }
	 
	  public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
  }
}
