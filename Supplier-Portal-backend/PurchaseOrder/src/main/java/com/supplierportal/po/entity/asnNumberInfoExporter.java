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

public class asnNumberInfoExporter {

	private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<asnNumberInfo> listasnInfo;
	
	 
	 public asnNumberInfoExporter(List<asnNumberInfo> listasnInfo) {
		 this.listasnInfo=listasnInfo;
	     workbook = new XSSFWorkbook();
	     sheet= workbook.createSheet("asnNumberExcel");
	}
	 
	 private void writeHeaderLine() {
	        
	        Row row = sheet.createRow(0);
	         
	       Cell cell=row.createCell(0);
	       cell.setCellValue("id");
	       
	        cell=row.createCell(1);
	       cell.setCellValue("CreationDate");
	       
	       cell=row.createCell(2);
	       cell.setCellValue("DCNumber");
	       
	       cell=row.createCell(3);
	       cell.setCellValue("totalItems");
	       
	       cell=row.createCell(4);
	       cell.setCellValue("ShippingQuantity");
	       
	       cell=row.createCell(5);
	       cell.setCellValue("ShippingDate");
	       
	       cell=row.createCell(6);
	       cell.setCellValue("ETA");
	       
	       cell=row.createCell(7);
	       cell.setCellValue("Location");
	                 
	    }
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	                 
	        for (asnNumberInfo asnNumber :listasnInfo ) {
	            XSSFRow row = sheet.createRow(rowCount++);
	            Cell cell=row.createCell(0);
	            cell.setCellValue(asnNumber.getId());
	            
	            cell=row.createCell(1);
	            cell.setCellValue(asnNumber.getCreationDate());
	            
	            cell=row.createCell(2);
	            cell.setCellValue(asnNumber.getDcNumber());
	            
	            cell=row.createCell(3);
	            cell.setCellValue(asnNumber.getTotalItems());
	            
	            cell=row.createCell(4);
	            cell.setCellValue(asnNumber.getShippingQty());
	            
	            cell=row.createCell(5);
	            cell.setCellValue(asnNumber.getShippingDate());
	            
	            cell=row.createCell(6);
	            cell.setCellValue(asnNumber.getEta());
	           
	            cell=row.createCell(7);
	            cell.setCellValue(asnNumber.getLocation());
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
