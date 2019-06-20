package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {
//Frist we need to bring path
	@Test
	
	public void readExcel() throws IOException {//IOEException is the most general exception , we can specifiy Exception instead of IOEExcetion
	String xlpath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlpath);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//Open specified sheet
	XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
	String value=sheet.getRow(6).getCell(0).toString();
	System.out.println(value);
	
	//get number of rows and columns
	int row=sheet.getPhysicalNumberOfRows();
	int col=sheet.getRow(0).getLastCellNum();
	
	System.out.println("number of row and col are "+row+" , "+col);
	// get value from each cell 1 by 1
	
	for(int i=0; i<row; i++) {
		for (int j=0; j<col; j++) {
			String data=sheet.getRow(i).getCell(j).toString();
			System.out.print(data);
		}
	}
	
	//close workbook
	
	workbook.close();
	fis.close();
	}	
}
