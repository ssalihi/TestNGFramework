package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo {
	@Test
	public void readExcel() throws IOException {
	//First thing we have to bring fileIput Stream
		String xlpath="src/test/resources/testData/OrangeHrmData.xlsx";
		FileInputStream fis=new FileInputStream(xlpath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);//WorkBook
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails");//Sheet
		//XSSFRow row=sheet.getRow(1);// this one by one
		
		String value=sheet.getRow(1).getCell(3).toString();// we have specifiy the row and cell
		System.out.println(value);
		
		String value1=sheet.getRow(4).getCell(0).toString();
		System.out.println(value1);
		//how to find number of rows
		int rowNum=sheet.getPhysicalNumberOfRows();
		//how to find number of cell
		int cellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(cellNum);
		
	//Retrive all data
		for (int i=0; i<rowNum; i++) {
			for (int j=0; j<cellNum; j++) {
				String cellValue=sheet.getRow(i).getCell(j).toString();
				System.out.print(cellValue+ " ");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	
	}

}
