package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {
	@Test
	public void writeExcel() throws Exception {
String xlpath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlpath);
	//Open Work
	XSSFWorkbook wbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=wbook.getSheet("EmployeeDetails");
	
	//Write sth in excel
	sheet.getRow(0).createCell(4).setCellValue("result");
	// adding some value
	sheet.getRow(0).createCell(4).setCellValue("Pass");
	sheet.getRow(1).createCell(4).setCellValue("Fail");
	// adding another first name
	//sheet.createRow(11).createCell(0).setCellValue("sekander");
	
	//write some value
	
	FileOutputStream fos=new FileOutputStream(xlpath);
	
	wbook.write(fos);
	
	fos.close();
	wbook.close();
	fis.close();
	
}
}
