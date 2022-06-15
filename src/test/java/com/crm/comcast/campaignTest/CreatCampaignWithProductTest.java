package com.crm.comcast.campaignTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepository.CampaignConfirmationPage;
import com.crm.comcast.pomrepository.CampaignPage;
import com.crm.comcast.pomrepository.CreateCampaignPage;
import com.crm.comcast.pomrepository.CreateProductPage;
import com.crm.comcast.pomrepository.Homepage;
import com.crm.comcast.pomrepository.ProductCreateConfirmationPage;
import com.crm.comcast.pomrepository.ProductPage;

import genericUtility.Baseclass1;
import genericUtility.ExcelUtility;

public class CreatCampaignWithProductTest extends Baseclass1 {
	@Test 
	public void createcampaign() throws Throwable 
	{	
		
		/*get Random Number*/
		int randomNum = jutil.getRandomNum();

	/* To read the data from EXCEL*/
		ExcelUtility excelutil = new ExcelUtility();
		String productnName = excelutil.getExceldata("Product", 0, 0)+randomNum;
		String campaignName = excelutil.getExceldata("Campaign", 0, 0)+randomNum;

		String productpage = "Product&action";
		String campaignPage = "Campaigs&action";
//
//	Send URL
//		driver.get(url);

	// Login to Application 
//		LoginPage log = new LoginPage(driver);
//		log.LoginToApp1(username, password);

		// Click on Campaign Tab in Homepage
		Homepage home = new Homepage(driver);
		home.getProductMtb().click();
		
	// Click on Create product button in campaign page
		ProductPage product = new ProductPage(driver);
		product.getCreateProductBTN().click();
		
	// in create product page send product name and click save button
		CreateProductPage CreProduct = new CreateProductPage(driver);
		CreProduct.createProductPageMenu(productnName);
		
	// in product confirmation verify the  message
		ProductCreateConfirmationPage ProductConfirmPage = new ProductCreateConfirmationPage(driver);
		String message = ProductConfirmPage.getProductCreatConfirmnText().getText();
		Assert.assertEquals(message.contains(productnName), true);
		System.out.println(message);
//		if(message.contains(productnName))
//		{
//			System.out.println("product created");
//		}
//		else
//		{
//			System.out.println("product not created");
//		}

	// goto campaign page		
		home.campaignTab(driver);
		CampaignPage campaign = new CampaignPage(driver);
		
	// Click on create Campaign button
		campaign.getCreatCampaignBtn().click();
		
	// in create campaign page send campaign Name , select product, switch to window and save the campaign
		//WebDriver driver = new ChromeDriver();
		CreateCampaignPage CreCampaign = new CreateCampaignPage(driver);
		CreCampaign.Createapmaignwithproduct(driver, campaignName, productnName, productpage, campaignPage);

	// in campaign confirmation page verify the  message
		CampaignConfirmationPage campainConfirPage = new CampaignConfirmationPage(driver);
		String message2 = campainConfirPage.getConfirmationText().getText();
		Assert.assertEquals(message2.contains(campaignName), true);
//		if(message2.contains(campaignName))
//		{ss
//			System.out.println("Campaign created");
//		}
//		else
//		{
//			System.out.println("Campaign not created");
//		}
		
	}
}
