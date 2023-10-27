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

public class poSummaryExport {
	 private XSSFWorkbook workbook;
	 private XSSFSheet sheet;
	 private List<purchaseOrder> listPO;
	 
	 public poSummaryExport(List<purchaseOrder> listPO) {
			// TODO Auto-generated constructor stub
			    this.listPO = listPO;
		        workbook = new XSSFWorkbook();
		        sheet= workbook.createSheet("PurchaseOrderExcel");
	 }        
		        private void writeHeaderLine(){
		        	
		           Row row = sheet.createRow(0);
			         
		  	       Cell cell=row.createCell(0);
		  	       cell.setCellValue("poId");
		  	       
		  	       cell=row.createCell(1);
			       cell.setCellValue("Location");
			       
			       cell=row.createCell(2);
			       cell.setCellValue("Creation Date");
			       
			       cell=row.createCell(3);
			       cell.setCellValue("Ship by Date");
			       
			       cell=row.createCell(4);
			       cell.setCellValue("Estimated Delivery Date");
			       
			       cell=row.createCell(5);
			       cell.setCellValue("Total Quantity");
			       
			       cell=row.createCell(6);
			       cell.setCellValue("Lead Time");
			       
			       cell=row.createCell(7);
			       cell.setCellValue("Total Items");
			       
			       cell=row.createCell(8);
			       cell.setCellValue("Total Cost");
			       
			       cell=row.createCell(9);
			       cell.setCellValue("Percent Cost");   
		        
		}
		        
		        private void writeDataLines() {
			        int rowCount = 1;
			                 
			        for (purchaseOrder purchase : listPO) {
			            XSSFRow row = sheet.createRow(rowCount++);
			            Cell cell=row.createCell(0);
			            cell.setCellValue(purchase.getPoId());
			            
			            cell=row.createCell(1);
			            cell.setCellValue(purchase.getLocation());
			            
			            cell=row.createCell(2);
			            cell.setCellValue(purchase.getCreationDate());
			            
			            cell=row.createCell(3);
			            cell.setCellValue(purchase.getShipByDate());
			            
			            cell=row.createCell(4);
			            cell.setCellValue(purchase.getEstimatedDeliveryDate());
			            
			            cell=row.createCell(5);
			            cell.setCellValue(purchase.getPoQty());
			            
			            cell=row.createCell(6);
			            cell.setCellValue(purchase.getLeadTime());
			            
			            cell=row.createCell(7);
			            cell.setCellValue(purchase.getTotalItems());
			            
			            cell=row.createCell(8);
			            cell.setCellValue(purchase.getTotalCost());
			            
			            cell=row.createCell(9);
			            cell.setCellValue(purchase.getPercentcost());
			           
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
