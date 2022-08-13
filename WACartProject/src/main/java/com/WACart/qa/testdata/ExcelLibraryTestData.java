package com.WACart.qa.testdata;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelLibraryTestData {

	@Test
	public void readexcel() throws Exception {
		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\git\\WACart local\\WACartProject\\src\\test\\resources\\testData\\TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("HomePage");

		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {

			int cols = sh.getRow(i).getLastCellNum();

			for (int j = 0; j < cols; j++) {

				Cell c = sh.getRow(i).getCell(j);
				df.formatCellValue(c);

				System.out.println(df.formatCellValue(c));
			}

		}

	}
}
