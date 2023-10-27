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

public class asnInfoExporter {
	private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<asnInfo> listasnInfo;
	
	 
	 public asnInfoExporter(List<asnInfo> listasnInfo) {
		 this.listasnInfo=listasnInfo;
	     workbook = new XSSFWorkbook();
	     sheet= workbook.createSheet("asnNumberExcel");
	}
	 
	 private void writeHeaderLine() {
	        
	        Row row = sheet.createRow(0);
	         
	       Cell cell=row.createCell(0);
	       cell.setCellValue("ItemId");
	       
	        cell=row.createCell(1);
	       cell.setCellValue("Items");
	       
	       cell=row.createCell(2);
	       cell.setCellValue("POQtyr");
	       
	       cell=row.createCell(3);
	       cell.setCellValue("DeliveredQty");
	       
	       cell=row.createCell(4);
	       cell.setCellValue("ShippedQty");
	                  
	    }
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	                 
	        for (asnInfo asninfo :listasnInfo ) {
	            XSSFRow row = sheet.createRow(rowCount++);
	            Cell cell=row.createCell(0);
	            cell.setCellValue(asninfo.getItemId());
	            
	            cell=row.createCell(1);
	            cell.setCellValue(asninfo.getItems());
	            
	            cell=row.createCell(2);
	            cell.setCellValue(asninfo.getPoQty());
	            
	            cell=row.createCell(3);
	            cell.setCellValue(asninfo.getDeliveredQty());
	            
	            cell=row.createCell(4);
	            cell.setCellValue(asninfo.getShippedQty());
	            
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
