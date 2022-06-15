package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	WebDriver driver;
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrganisationTF;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBTn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganisationTF() {
		return OrganisationTF;
	}

	public WebElement getSaveBTn() {
		return saveBTn;
	}

	
	public String CreateOrganisationPageamenu(String OrganisationName)
	{
		OrganisationTF.sendKeys(OrganisationName);
		saveBTn.click();
		return OrganisationName;
		
	}
	
	
}
