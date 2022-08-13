package com.WACart.qa.testdata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderTestData {
	
	//DataProviderTestData	dp =new DataProviderTestData();
	
	Cell c =null;

	@DataProvider(name ="searchproduct")
    public String[][] searchData() throws Exception{
		
		Cell c =null;
	   DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\git\\WACart local\\WACartProject\\src\\test\\resources\\testData\\TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("HomePage");

		int rows = sh.getLastRowNum();
		
		String [][] data= new String [rows][1];
		for (int i = 1; i <= rows; i++) {

		data [i-1][0]=df.formatCellValue(sh.getRow(i).getCell(0));
		}
		
		return data;
}
   
   
	

}
