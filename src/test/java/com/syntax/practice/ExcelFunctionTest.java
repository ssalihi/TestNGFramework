package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionTest {
@Test
public void excelTest() {
	ExcelUtility obj=new ExcelUtility();
	obj.openExcel(Constant.XL_FILEPATH, "EmployeeDetails");
	//String value=obj.getCellData(2, 3);
	//System.out.println(value);
	
	//retreive all value from excel and store into DataProvider (2D object array)
	int row=obj.getRowNum();
	int cell=obj.getColNum(0);
	Object[][] data=new Object[row][cell];
	
	for (int i=1; i<row; i++) {
		for (int y=0; y<cell; y++) {
			//retrieve value form excel
		String value1=obj.getCellData(i,y);
		//store inside 2D array
		data[i][y]=value1;
		}
	}
	System.out.println(data.length);
	
}
}
