package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_AddDocumentTest {
	public static void main(String[] args) throws Throwable 
	{

	/* Creating object for all Utility classes*/
	
	WebdriverUtility webdriutil = new WebdriverUtility();
	JavaUtility jutil = new JavaUtility();
	ExcelUtility excelutil = new ExcelUtility();
	FileUtility fileutil = new FileUtility();
	
	/* read common data from Property file*/
	String browser = fileutil.getKeyandValue("browser");
	String url = fileutil.getKeyandValue("url");
	String username = fileutil.getKeyandValue("username");
	String password = fileutil.getKeyandValue("password");
	
	/*get Random Number*/
	 int randomNum = jutil.getRandomNum();
	 
	 /* To read the data from EXCEL*/
	 String address = excelutil.getExceldata("Address", 0, 0)+randomNum;
	 String product = excelutil.getExceldata("Product", 0, 0)+randomNum;
	 String subject = excelutil.getExceldata("Subject", 0, 0)+randomNum;
	
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
	driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
	driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	webdriutil.swithToWindow(driver, "Vendors&action");
	
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.xpath("//a[@class='listFormHeaderLinks']/../../../tr[2]/td[1]/a")).click();
	Thread.sleep(2000);
	
	webdriutil.swithToWindow(driver, "PurchaseOrder&action");
	
	driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(address);
	driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(address);
	driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
	
	webdriutil.swithToWindow(driver, "Products&action");
	
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("bag");
	driver.findElement(By.xpath("//input[@name='search']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='select_all']/../../../tr[2]/td[2]/a")).click();
	
	webdriutil.swithToWindow(driver, "PurchaseOrder&action");
	
	driver.findElement(By.xpath("//input[@class='detailedViewTextBoxOn']")).sendKeys("10");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String message = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(message.contains(subject))
	{
		System.out.println("purchase order created");
	}
	else
	{
		System.out.println("purchase order not created");
	}
	
	WebElement ele2 = driver.findElement(By.xpath("//a[.='More Information']"));
	webdriutil.mouseOverOnElement(driver, ele2);

	driver.findElement(By.xpath("//a[@class='drop_down']/../../../tr[2]/td[1]/a")).click();
	driver.findElement(By.xpath("//input[@title='Add Document']")).click();
	
	Thread.sleep(4000);
	driver.quit();
		
}
	}


