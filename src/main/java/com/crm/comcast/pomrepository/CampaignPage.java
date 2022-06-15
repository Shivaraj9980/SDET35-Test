package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreatCampaignBtn() {
		return CreatCampaignBtn;
	}

	@FindBy(xpath ="//img[@title='Create Campaign...']" )
	private WebElement CreatCampaignBtn;
	
	

}
