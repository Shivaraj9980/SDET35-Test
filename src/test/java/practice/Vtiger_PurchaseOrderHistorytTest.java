package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.FileUtility;
import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_PurchaseOrderHistorytTest {
	public static void main(String[] args) throws Throwable 
	{

	/* Creating object for all Utility classes*/
	
	WebdriverUtility webdriutil = new WebdriverUtility();
	FileUtility fileutil = new FileUtility();
	
	/* read common data from Property file*/
	String browser = fileutil.getKeyandValue("browser");
	String url = fileutil.getKeyandValue("url");
	String username = fileutil.getKeyandValue("username");
	String password = fileutil.getKeyandValue("password");
	 
	/*Launch the  browser*/	
	 WebDriver driver = null;
		if (browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
	
	webdriutil.waitForElement(driver);
	driver.manage().window().maximize();
	driver.get(url);
	/* login to page*/
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	WebElement ele1 = driver.findElement(By.xpath("//a[.='More']"));
	webdriutil.mouseOverOnElement(driver, ele1);
	driver.findElement(By.xpath("//a[@name='Purchase Order']")).click();
	
	driver.findElement(By.xpath("//a[@class='listFormHeaderLinks']/../../../tr[3]/td[3]/a")).click();
	Thread.sleep(2000);
	
	WebElement ele2 = driver.findElement(By.xpath("//a[.='More Information']"));
	webdriutil.mouseOverOnElement(driver, ele2);
	
	driver.findElement(By.xpath("//a[.='PurchaseOrder Status History']")).click();
	
	String message = driver.findElement(By.xpath("//i")).getText();
	if(message.contains("None Included"));
	{
		System.out.println("No History");
	}
	
	
	Thread.sleep(4000);
	driver.quit();
		
}
	}


