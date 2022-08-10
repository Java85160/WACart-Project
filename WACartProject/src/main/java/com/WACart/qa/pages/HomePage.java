package com.WACart.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.WACart.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[text()='WACart']")
	WebElement linkwacart;

	@FindBy(id = "navbarsearchform-keyword")
	WebElement searchbox;

	@FindBy(xpath = "//input[@name='SearchForm[keyword]']")
	WebElement textsearchbox;

	@FindBy(xpath = "//div[@class='product-thumb transition']")
	List<WebElement> searchresult;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchboxhit;

	@FindBy(xpath = "//span[@class='icon-next']")
	WebElement clicknext;

	@FindBy(xpath = "//span[@class='icon-prev']")
	WebElement clickprev;

	@FindBy(xpath = "//nav[@id='menu']//a[text()='Desktops']")
	WebElement desktoplink;

	@FindBy(xpath = "//nav[@id='menu']//a[text()='Laptops & Notebooks']")
	WebElement laptopnotebooklink;

	@FindBy(xpath = "//nav[@id='menu']//a[text()='Camera']")
	WebElement cameralink;

	@FindBy(xpath = "//ul[@class='list-inline']")
	WebElement currencyselect;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	
	public String wacartLogo() {

		 linkwacart.click();
		 String getTitileHomepage= driver.getTitle();
		
		return getTitileHomepage;

	}

	public boolean searchBoxPresent() {
		return	textsearchbox.isDisplayed();


	}
	
	

	public SearchResultPage searchResult(String item) {
		textsearchbox.sendKeys(item);
		searchboxhit.click();

		return new SearchResultPage();

	}

	public boolean nextKey() {

		return clicknext.isDisplayed();
		

	}

	public boolean previewKey() {

		
		return	clickprev.isDisplayed();
	

	}

	public DeskTops desktopsLinkPresent() {

		desktoplink.click();
		return new DeskTops();

	}

	
	public LaptopAndNotebooks laptopAndNotebooksLinkPresent() {

		laptopnotebooklink.click();
		return new LaptopAndNotebooks();

	}
	
	public Camera cameraLinkPresent() {

		cameralink.click();
		return new Camera();

	}
	
	
	
	public void currencyoption() {
	currencyselect.click();
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		initialization();
		LoginPage lp = new LoginPage();
		lp.login("Sanjay","Java@123");
		
		HomePage hp =new HomePage(driver);
		//hp.desktopsLinkPresent();
		//hp.wacartLogo();
	//	hp.currencyoption();
		
		hp.wacartLogo();
		
	} 
	
	
	
	
}
