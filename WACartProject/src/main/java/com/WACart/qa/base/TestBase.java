package com.WACart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.internal.BaseClassFinder;

import com.WACart.qa.util.PropertiesUtils;
import com.WACart.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	
	public static void main(String[] args) throws Exception {
		initialization()	;
	}
	
	public static WebDriver driver= null;
	public static Logger log = Logger.getLogger(BaseClassFinder.class);
	
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	 public static ExtentSparkReporter spark=null;
	
	public static void initialization() throws Exception {
		
		
		
		System.out.println("initialization browser");
		log.info("Initialization browser");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ingecnotechnologies.com/other/WACart/customer/site/login");
//		//if (browserName.equals("chrome")) {
//			
//			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		if(browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//				
//		}
		driver.manage().window().maximize();
		//driver.get(PropertiesUtils.readProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		
	}
	
//	public void reportInit() {
//		report=new ExtentReports();
//		spark =new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
//		report.attachReporter(spark);
		
	//}
		
		
	
}
