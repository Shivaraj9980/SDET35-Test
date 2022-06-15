package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class CreateCampaignPage extends WebdriverUtility {

//WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement CampaignNameTF;

	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBTn;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement AddProductBtn;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement ProductSearchTF;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement SearchNowBTN;

	@FindBy(xpath = "//a[@class='listFormHeaderLinks']/../../../tr[2]/td[1]/a")
	private WebElement SelectProductChekBox;

	public WebElement getProductSearchTF() {
		return ProductSearchTF;
	}

	public WebElement getSearchNowBTN() {
		return SearchNowBTN;
	}

	public WebElement getSelectProductChekBox() {
		return SelectProductChekBox;
	}

	public WebDriver getDriver(WebDriver driver) {
		return driver;
	}

	public WebElement getCampaignNameTF() {
		return CampaignNameTF;
	}

	public WebElement getSaveBTn() {
		return saveBTn;
	}

	public WebElement getAddProductBtn() {
		return AddProductBtn;
	}

	public void switchtoPage(WebDriver driver, String PartialText) {
		swithToWindow(driver, PartialText);
	}

	public String Createapmaign(String campaignName) {

		CampaignNameTF.sendKeys(campaignName);
		saveBTn.click();
		return campaignName;
	}

	public void Createapmaignwithproduct(WebDriver driver, String campaignName, String productnName, String productpage,
			String campaignPage) throws InterruptedException {
		CampaignNameTF.sendKeys(campaignName);
		AddProductBtn.click();
		switchtoPage(driver, productpage);
		ProductSearchTF.sendKeys(productnName);
		SearchNowBTN.click();
		SelectProductChekBox.click();
		switchtoPage(driver, productpage);
		saveBTn.click();

	}

}
