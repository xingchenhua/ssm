package com.neusoft.wuye.test;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test002 {

	public static void main(String[] args) {

		try{
			Workbook wb = new XSSFWorkbook();
			
			Sheet sheet1 = wb.createSheet("new sheet");
			Sheet sheet2 = wb.createSheet("second sheet");
			
			Row row = sheet1.createRow(0);
			
			Cell cell=row.createCell(0);
			cell.setCellValue("≤‚ ‘ ˝æ›");
			
			
		    FileOutputStream fileOut = new FileOutputStream("d:/temp/d001.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
	    
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}

}
