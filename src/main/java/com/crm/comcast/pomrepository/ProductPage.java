package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@title='Create Product...']")
	private WebElement CreateProductBTN;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProductBTN() {
		return CreateProductBTN;
	}
	
	public void ProductPageMenu()
	{
		CreateProductBTN.click();
	}
	}
