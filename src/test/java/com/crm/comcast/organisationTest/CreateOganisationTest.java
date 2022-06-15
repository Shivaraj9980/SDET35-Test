package com.crm.comcast.organisationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepository.CreateOrganisationConfirmPage;
import com.crm.comcast.pomrepository.CreateOrganisationPage;
import com.crm.comcast.pomrepository.Homepage;
import com.crm.comcast.pomrepository.LoginPage;
import com.crm.comcast.pomrepository.OrganisationPage;

import genericUtility.Baseclass1;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOganisationTest extends Baseclass1 {

	@Test

	public void CreateOrganisattion() throws IOException, Throwable 
	{
		//		/* Creating object for all Utility classes*/
		//
		//		WebdriverUtility webdriutil = new WebdriverUtility();
		//		JavaUtility jutil = new JavaUtility();
		//		ExcelUtility excelutil = new ExcelUtility();
		//		FileUtility fileutil = new FileUtility();
		//
		//		/* read common data from Property file*/
		//		String browser = fileutil.getKeyandValue("browser");
		//		String url = fileutil.getKeyandValue("url");
		//		String username = fileutil.getKeyandValue("username");
		//		String password = fileutil.getKeyandValue("password");

		/*get Random Number*/
		int randomNum = jutil.getRandomNum();

		/* To read the data from EXCEL*/
		String organisation = excelutil.getExceldata("Organisation", 0, 0)+randomNum;

		//		/*Launch the  browser*/	
		//		WebDriver driver = null;
		//		if (browser.equals("Chrome"))
		//		{
		//			WebDriverManager.chromedriver().setup();
		//			driver= new ChromeDriver();		
		//		}
		//		webdriutil.waitForElement(driver);
		//		driver.manage().window().maximize();
		//		
		//	//Send URL
		//		driver.get(url);
		//
		//	// Login to Application 
		//		LoginPage log = new LoginPage(driver);
		//		log.LoginToApp1(username, password);

		// Click on Organiation Tab in Homepage
		Homepage home = new Homepage(driver);
		home.getOrganisationMtab().click();

		// Click on create Organiation button	
		OrganisationPage orgpage = new OrganisationPage(driver);
		orgpage.getCreateorganisationBTN().click();

		// in Create Organisation page send Organisation name and save
		CreateOrganisationPage createorganise = new CreateOrganisationPage(driver);
		createorganise.CreateOrganisationPageamenu(organisation);

		// in Organisation confirmation page verify the message

		CreateOrganisationConfirmPage orgCinfirmatintext = new CreateOrganisationConfirmPage(driver);
		String message = orgCinfirmatintext.getOrganisationCoinfirmationText().getText();

		Assert.assertEquals(message.contains(organisation), true);
		//		if(message.contains(organisation))
		//		{
		//			System.out.println("organisation created");
		//		}
		//		else
		//		{
		//			System.out.println("organisation not created");
		//		}

		//	// Logout to Application
		//		home.logout(driver);

	}
}


