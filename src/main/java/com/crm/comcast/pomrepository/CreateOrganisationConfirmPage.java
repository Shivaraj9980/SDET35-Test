package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationConfirmPage {
	WebDriver driver;
	public CreateOrganisationConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement OrganisationCoinfirmationText;
	
	public WebElement getOrganisationCoinfirmationText() {
		return OrganisationCoinfirmationText;
	}


	public void getOrganisationConfirmationText() 
	{
	OrganisationCoinfirmationText.getText();
	}
	
}

