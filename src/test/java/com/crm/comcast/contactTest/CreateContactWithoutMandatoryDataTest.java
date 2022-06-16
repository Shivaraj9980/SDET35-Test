package com.crm.comcast.contactTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass1;
import com.crm.comcast.pomrepository.ContactPage;
import com.crm.comcast.pomrepository.CreateContactConfirPage;
import com.crm.comcast.pomrepository.CreateContactPage;
import com.crm.comcast.pomrepository.Homepage;

public class CreateContactWithoutMandatoryDataTest extends Baseclass1 {
	@Test(groups={"regressionTest", "SmokeTest"})
	public void createWithoutMandatoryfieldTest() throws IOException, Throwable 
	{	
/* Creating object for all Utility classes*/
		
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
//		
		/*get Random Number*/
		 int randomNum = jutil.getRandomNum();
		 
		 /* To read the data from EXCEL*/
		 String contact = excelutil.getExceldata("Contact", 0, 0)+randomNum;
	
//		/*Launch the  browser*/	
//		 WebDriver driver = null;
//			if (browser.equals("Chrome"))
//			{
//				WebDriverManager.chromedriver().setup();
//				driver= new ChromeDriver();
//			}
//		webdriutil.waitForElement(driver);
//		driver.manage().window().maximize();
//		
//	//Send URL
//		driver.get(url);
//		
//	// Login to Application 
//		LoginPage log = new LoginPage(driver);
//		log.LoginToApp1(username, password);
//		
	// Click on Contact Tab in Homepage
		Homepage home = new Homepage(driver);
		home.getContactMTab().click();
		
	//Click on Create Contact button
		ContactPage con = new ContactPage(driver);
		con.getCreateContactBTN().click();
		
	//Send last Name  and click on Save button
		CreateContactPage create = new CreateContactPage(driver);
		create.CreateWithoutMandatoryData();
		
	// Handle alert
		String alertMessage = "Last Name cannot be empty";
		create.acceptAlertAndConfirm(driver, alertMessage);
		
	
//	 Logout to Application
//		
//		home.logout(driver);
//		Thread.sleep(4000);
//		driver.quit();
	}
		
}

