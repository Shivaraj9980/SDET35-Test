package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement ProductNameTF;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement ProductSaveBTN;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameTF() {
		return ProductNameTF;
	}

	public WebElement getProductSaveBTN() {
		return ProductSaveBTN;
	}
	
	public String createProductPageMenu(String ProductName)
	{
		ProductNameTF.sendKeys(ProductName);
		ProductSaveBTN.click();
		return ProductName;
	}

}
