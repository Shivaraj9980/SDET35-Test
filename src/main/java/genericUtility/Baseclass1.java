package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcast.pomrepository.Homepage;
import com.crm.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass1 {
	public WebDriver driver;
	

	/* Creating object for all Utility classes*/
	public ExcelUtility excelutil = new ExcelUtility();
	public FileUtility filiUtil=new FileUtility();
	public WebdriverUtility webdriutil=new WebdriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups={"regressionTest", "SmokeTest"})
	public void bs()
	{
		System.out.println("Establisg Database Connection");
	}
	@BeforeTest(groups={"regressionTest", "SmokeTest"})
	public void bt()
	{
		System.out.println("select Type of execution");
	}
	//@Parameters("Browser")
	@BeforeClass(groups={"regressionTest", "SmokeTest"})
	//public void lanuchBrowser(String Browser) throws Throwable
	public void lanuchBrowser() throws Throwable
	{

		String Browser1 = filiUtil.getKeyandValue("browser");
		String url = filiUtil.getKeyandValue("url");
		if (Browser1.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(Browser1.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		}
		else
		{
			WebDriverManager.operadriver().setup();
			driver= new OperaDriver();
		}
		webdriutil.waitForElement(driver);
		driver.manage().window().maximize();
		
		sdriver= driver;
		//Send URL
		driver.get(url);
		System.out.println("Browser and webpage launched Successful");
	}
	@BeforeMethod(groups={"regressionTest", "SmokeTest"})
	public void bm() throws Throwable
	{
		LoginPage login = new LoginPage(driver);
		String Un = filiUtil.getKeyandValue("username");
		String Pwd = filiUtil.getKeyandValue("password");
		System.out.println(Un+ Pwd);
		
		login.LoginToApp1(Un, Pwd);
		System.out.println("Login successful");
	}
	@AfterMethod(groups={"regressionTest", "SmokeTest"})
	public void am()
	{
		Homepage homepage = new Homepage(driver); 
		homepage.logout(driver);
		System.out.println("Logout Succesful");
	}

	@AfterClass(groups={"regressionTest", "SmokeTest"})
	public void ac()
	{
		driver.quit();
		System.out.println("Browser closed Succesfully");
	}
	@AfterTest(groups={"regressionTest", "SmokeTest"})
	public void at()
	{
		System.out.println("End of the execution");
	}
	@AfterSuite(groups={"regressionTest", "SmokeTest"})
	public void as()
	{
		System.out.println("Database Connection closed");
	}

}
