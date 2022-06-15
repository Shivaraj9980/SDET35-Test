package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBTN;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement SearchTF;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactBTN() {
		return createContactBTN;
	}

	public WebElement getSearchBtn() {
		return SearchTF;
	}
	
	public String ContactPageMenu(String searchTextfield)
	{
		createContactBTN.click();
		SearchTF.sendKeys(searchTextfield);
		return searchTextfield;
	}


		
	}
	
	


