package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility {
	WebDriver driver;
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastnameTF;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLastnameTF() {
		return LastnameTF;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public String CreatepageMenu(String SearchValue)
	{
		LastnameTF.sendKeys(SearchValue);
		SaveBtn.click();
		return SearchValue;
	}
	public void CreateWithoutMandatoryData()
	{
		SaveBtn.click();
	}
	public void acceptAlertAndConfirm(WebDriver driver, String AlertMsg)
	{
		swithToAlertWindowAndAccpect(driver, AlertMsg);
		System.out.println("Alert message Displayed as " + AlertMsg);
	}
		
	
	
}
