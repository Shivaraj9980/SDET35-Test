package com.crm.comcast.campaignTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass1;
import com.crm.comcast.pomrepository.CampaignPage;
import com.crm.comcast.pomrepository.CreateCampaignPage;
import com.crm.comcast.pomrepository.CreateContactConfirPage;
import com.crm.comcast.pomrepository.Homepage;
public class CreatCampaignTest extends Baseclass1 {
	@Test(groups={"regressionTest", "SmokeTest"})
	public void createcampTest() throws IOException, Throwable 
	{

		/*get Random Number*/
		int randomNum = jutil.getRandomNum();

		/* To read the data from EXCEL*/
		String campaignName = excelutil.getExceldata("Campaign", 0, 0)+randomNum;

		// Click on Campaign Tab in Homepage
		Homepage home = new Homepage(driver);
		home.campaignTab(driver);

		// Click on create Campaign button
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreatCampaignBtn().click();

		// in create campaign page send campaign Name and save the campaign
		CreateCampaignPage create = new CreateCampaignPage(driver);
		create.getCampaignNameTF().sendKeys(campaignName);
		create.getSaveBTn().click();

		// in campaign confirmation page verify the  message
		CreateContactConfirPage confirmmessage = new CreateContactConfirPage(driver);
		String message = confirmmessage.campaignconfirmation();
		Assert.assertEquals(message.contains(campaignName), true);
		System.out.println("CampaignCreated with message as"+message);
		//		if(message.contains(campaignName))
		//		{
		//			System.out.println("Campaign created");
		//		}
		//		else
		//		{
		//			System.out.println("Campaign not created");
		//		}


	}
}

