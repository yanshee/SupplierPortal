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

public class asnDetailsExport {
	private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<asnDetails> listasn;
	 
	 public asnDetailsExport(List<asnDetails> listasn) {
		 this.listasn=listasn;
	     workbook = new XSSFWorkbook();
	     sheet= workbook.createSheet("asnDetailsExcel");
	}
	 
	 private void writeHeaderLine() {
	        
	        Row row = sheet.createRow(0);
	         
	       Cell cell=row.createCell(0);
	       cell.setCellValue("id");
	       
	        cell=row.createCell(1);
	       cell.setCellValue("asnCount");
	       
	       cell=row.createCell(2);
	       cell.setCellValue("containerCount");
	       
	       cell=row.createCell(3);
	       cell.setCellValue("asnDetails");
	       
	       cell=row.createCell(4);
	       cell.setCellValue("containerDetails");
	               
	    }
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	                 
	        for (asnDetails asn : listasn) {
	            XSSFRow row = sheet.createRow(rowCount++);
	            Cell cell=row.createCell(0);
	            cell.setCellValue(asn.getId());
	            
	            cell=row.createCell(1);
	            cell.setCellValue(asn.getAsnCount());
	            
	            cell=row.createCell(2);
	            cell.setCellValue(asn.getContainerCount());
	            
	            cell=row.createCell(3);
	            cell.setCellValue(asn.getAsnDetails());
	            
	            cell=row.createCell(4);
	            cell.setCellValue(asn.getContainerDetails());
	              
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
