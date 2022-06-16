package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebdriverUtility;

public class Homepage extends WebdriverUtility
{
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[.='Campaigns']")
	private WebElement CampaignMTab;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactMTab;
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement OrganisationMtab;
	
	@FindBy(xpath = "//a[.='More']")//a[.='Sign Out']
	private WebElement MoreDrpdwn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminLogo;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement Signout;
	
	@FindBy(xpath = "//a[@name='Purchase Order']")
	private WebElement PurchaseOrderMtab;
	
	@FindBy(xpath = "//a[.='Products']")
	private WebElement ProductMtb;
	
	public WebElement getProductMtb() {
		return ProductMtb;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignMTab() {
		return CampaignMTab;
	}

	public WebElement getContactMTab() {
		return contactMTab;
	}

	public WebElement getOrganisationMtab() {
		return OrganisationMtab;
	}

	public WebElement getMoreDrpdwn() {
		return MoreDrpdwn;
	}

	public WebElement getAdminLogo() {
		return AdminLogo;
	}

	public WebElement getSignout() {
		return Signout;
	}

	public WebElement getPurchaseOrderMtab() {
		return PurchaseOrderMtab;
	}
	
	public void logout(WebDriver driver)
	{
		
		mouseOverOnElement(driver, AdminLogo);
		waitForElement(driver, Signout);
		//AdminLogo.click();
		Signout.click();
	}
	
	public void campaignTab(WebDriver driver)
	{
		mouseOverOnElement(driver, MoreDrpdwn);
		CampaignMTab.click();
	}
	public void purchaseOrderTab()
	{
		mouseOverOnElement(driver, MoreDrpdwn);
		PurchaseOrderMtab.click();
	}
	
//	public void HomepageMenus()
//	{
//		contactMTab.click();
//		OrganisationMtab.click();
//		ProductMtb.click();
//	
//	}
//	
	
	
	
	
	
	
}
