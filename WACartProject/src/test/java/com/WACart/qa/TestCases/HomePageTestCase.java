package com.WACart.qa.TestCases;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.WACart.qa.base.TestBase;
import com.WACart.qa.pages.Camera;
import com.WACart.qa.pages.DeskTops;
import com.WACart.qa.pages.HomePage;
import com.WACart.qa.pages.LaptopAndNotebooks;
import com.WACart.qa.pages.LoginPage;
import com.WACart.qa.pages.SearchResultPage;
import com.WACart.qa.testdata.DataProviderTestData;

public class HomePageTestCase extends TestBase {
	DataProviderTestData dp = new DataProviderTestData()  ;
	LoginPage loginpage;
	HomePage homepage;
	SearchResultPage searchresultPage;
	DeskTops deskTops;
	LaptopAndNotebooks laptopAndNotebooks;
	Camera camera;

	@BeforeMethod
	public void setup() throws Exception {

		initialization();
		

	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("Testcases successfully closed");
		driver.quit();
	}

	@Test
	public void validateHomePage() throws Exception {
		loginpage = new LoginPage();
		loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		String actresult = driver.getTitle();
		String expresult = "Home";
		Assert.assertEquals(actresult, expresult);
		}

	@Test
	public void validateWACartLogo() throws Exception {
		loginpage = new LoginPage();
		loginpage.login("Sanjay", "Java@123");
		Thread.sleep(5000);
		String actresult = homepage.wacartLogo();
		String expresult = "Home";
		Assert.assertEquals(actresult, expresult);
		}

	@Test
	public void validatesearchBox() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(5000);
		boolean actresult = homepage.searchBoxPresent();
		Assert.assertTrue(actresult);
		}
	
	
	@Test(dataProvider = "searchproduct", dataProviderClass = DataProviderTestData.class)
	public void searchProduct(String item) throws Exception {
		
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		
		dp.searchData();
		Thread.sleep(3000);
		searchresultPage =homepage.searchResult(item);
		String actresult = driver.getTitle();
		String expresult = "Search Results";
		Assert.assertEquals(actresult, expresult);
		}
	
	
	@Test
	public void validateNextkey() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		boolean actresult =homepage.nextKey();
		Assert.assertTrue(actresult);
		}

	@Test
	public void validatePrevkey() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		boolean actresult =homepage.previewKey();
		Assert.assertTrue(actresult);
		}
	
	@Test
	public void validateDesktoplink() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		deskTops =homepage.desktopsLinkPresent();
		
		String actresult = driver.getTitle();
		String expresult = "Desktops";
		Assert.assertEquals(actresult, expresult);
		}
	
	@Test
	public void validateLaptopAndNotebooksLink() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		laptopAndNotebooks =homepage.laptopAndNotebooksLinkPresent();
		String actresult = driver.getTitle();
		String expresult = "Laptops & Notebooks";
		Assert.assertEquals(actresult, expresult);
		}
	
	@Test
	public void validateCameraLink() throws Exception {
		loginpage = new LoginPage();
		homepage = loginpage.login("Sanjay", "Java@123");
		Thread.sleep(3000);
		camera =homepage.cameraLinkPresent();
		String actresult = driver.getTitle();
		String expresult = "Camera";
		Assert.assertEquals(actresult, expresult);
		}
	
}
