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

public class poExcelExporter {
	 private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<purchaseOrder> listPO;
	 
	 public poExcelExporter(List<purchaseOrder> listPO) {
		// TODO Auto-generated constructor stub
		    this.listPO = listPO;
	        workbook = new XSSFWorkbook();
	        sheet= workbook.createSheet("PurchaseOrders");
	}

	
	 
	 private void writeHeaderLine() {
	        
	        Row row = sheet.createRow(0);
	         
	       Cell cell=row.createCell(0);
	       cell.setCellValue("poId");
	       
	        cell=row.createCell(1);
	       cell.setCellValue("location");
	       
	       cell=row.createCell(2);
	       cell.setCellValue("creationDate");
	       
	       cell=row.createCell(3);
	       cell.setCellValue("poQty");
	       
	       cell=row.createCell(4);
	       cell.setCellValue("totalItems");
	               
	    }
	 
	
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	 
//	        XSSFCellStyle style = workbook.createCellStyle();
//	        XSSFFont font = workbook.createFont();
//	        font.setFontHeight(14);
//	        style.setFont(font);
	                 
	        for (purchaseOrder purchase : listPO) {
	            XSSFRow row = sheet.createRow(rowCount++);
	            Cell cell=row.createCell(0);
	            cell.setCellValue(purchase.getPoId());
	            
	            cell=row.createCell(1);
	            cell.setCellValue(purchase.getLocation());
	            
	            cell=row.createCell(2);
	            cell.setCellValue(purchase.getCreationDate().toString());
	            
	            cell=row.createCell(3);
	            cell.setCellValue(purchase.getPoQty());
	            
	            cell=row.createCell(4);
	            cell.setCellValue(purchase.getTotalItems());
	            
	           // int columnCount = 0;
	             
	           
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
