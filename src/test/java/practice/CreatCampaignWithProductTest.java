package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreatCampaignWithProductTest {
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
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String message = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();

		if(message.contains(value))
		{
			System.out.println("product created");
		}
		else
		{
			System.out.println("product not created");
		}
		WebElement ele1 = driver.findElement(By.xpath("//a[.='More']"));
		Actions sct = new Actions(driver); 
		sct.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String win :child)
		{
			if(!child.equals(parent))
			{
				driver.switchTo().window(win);
				
			}
			
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		//driver.findElement(By.xpath("//a[@contains(text(),'Product Name ']"));
		driver.findElement(By.xpath("//a[.='ssss']")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		/*String message = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(message.contains(value))
		{
			System.out.println("Campaign created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
		*/
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions sct1 = new Actions(driver); 
		sct1.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);
		driver.quit();
			
			Thread.sleep(4000);
			driver.quit();
			


	}
}
