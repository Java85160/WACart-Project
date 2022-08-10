package com.WACart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.WACart.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//pageFactory
	@FindBy(id="loginform-username")
	WebElement username;
	
	@FindBy(id = "loginform-password")
	WebElement password;
	
	@FindBy(id = "savebutton")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-success']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
	WebElement WACartLogo;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myaccount;
	
	@FindBy(id = "w13")
	WebElement clickligin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateWACartLogo(){
		return WACartLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
		
	}
	

/*	public static void main(String[] args) throws Exception {
		
		initialization();
		LoginPage a =new LoginPage();
		
		a.login("Sanjay", "Java@123");
		
	} */

}
