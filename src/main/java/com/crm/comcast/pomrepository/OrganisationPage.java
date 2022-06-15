package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
WebDriver driver;
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateorganisationBTN;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateorganisationBTN() {
		return CreateorganisationBTN;
	}

}
