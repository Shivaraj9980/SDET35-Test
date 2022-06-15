package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreateConfirmationPage {
	WebDriver driver;
	public ProductCreateConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductCreatConfirmnText;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getProductCreatConfirmnText() {
		return ProductCreatConfirmnText;
	}
	
	public void productCreatCOnfirmnPageMEnu()
	{
		ProductCreatConfirmnText.getText();
	}

}
