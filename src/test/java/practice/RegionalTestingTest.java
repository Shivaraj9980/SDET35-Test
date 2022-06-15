package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.pomrepository.ContactPage;
import com.crm.comcast.pomrepository.CreateContactConfirPage;
import com.crm.comcast.pomrepository.CreateContactPage;
import com.crm.comcast.pomrepository.CreateOrganisationConfirmPage;
import com.crm.comcast.pomrepository.CreateOrganisationPage;
import com.crm.comcast.pomrepository.Homepage;
import com.crm.comcast.pomrepository.OrganisationPage;

import genericUtility.Baseclass1;

public class RegionalTestingTest extends Baseclass1{
	@Test(groups={"regressionTest", "SmokeTest"})
	public void createContact1() throws IOException, Throwable 
	{	
/* Creating object for all Utility classes*/
		

		/*get Random Number*/
		 int randomNum = jutil.getRandomNum();
		 
		 /* To read the data from EXCEL*/
		 String contact = excelutil.getExceldata("Contact", 0, 0)+randomNum;

	// Click on Contact Tab in Homepage
		Homepage home = new Homepage(driver);
		home.getContactMTab().click();
		
	//Click on Create Contact button
		ContactPage con = new ContactPage(driver);
		con.getCreateContactBTN().click();
		
	//Send last Name  and click on Save button
		CreateContactPage create = new CreateContactPage(driver);
		create.CreatepageMenu(contact);
		
	//Verify the Confirmation Page
		Thread.sleep(2000);
		CreateContactConfirPage contactinfo = new CreateContactConfirPage(driver);
		String message =contactinfo.getConfirmartioText().getText();
		
		if(message.contains(contact))
		{
			System.out.println("contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
	}
		
	
	
	@Test
		public void CreateOrganisattion() throws IOException, Throwable 
		{

			/*get Random Number*/
			int randomNum = jutil.getRandomNum();

			/* To read the data from EXCEL*/
			String organisation = excelutil.getExceldata("Organisation", 0, 0)+randomNum;


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
			
			if(message.contains(organisation))
			{
				System.out.println("organisation created");
			}
			else
			{
				System.out.println("organisation not created");
			}

		}
}
