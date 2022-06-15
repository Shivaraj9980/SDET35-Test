package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_PropertyfileWithMethod {	

	public static void main(String[] args) throws IOException, Throwable 
	{
		
		
		
		Random ran= new Random(); 
		int randomInt = ran.nextInt(50);
		
		
		FileInputStream fis = new FileInputStream("./property/vtiger.properties");
		Properties p= new Properties();
		p.load(fis);
		String browse = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pass = p.getProperty("password");
		//String orgname = p.getProperty("orgname");
		
		File src = new File("./Excel/Orgnames.xlsx");
		FileInputStream fis1 = new FileInputStream(src);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue()+randomInt;
		book.close();
		
		WebDriver driver = null;
		if (browse.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']/../../td[6]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...\']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);
		String message = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(message.contains(value))
		{
			System.out.println("organisation created");
		}
		else
		{
			System.out.println("organisation not created");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions sct = new Actions(driver); 
		sct.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);
		driver.quit();
		
	}
}
