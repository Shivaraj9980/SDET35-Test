package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin_propertyfile {
	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./property/vtiger.property");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser1");
		String url = p.getProperty("url1");
		String un = p.getProperty("username1");
		String pass = p.getProperty("password1");

		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
				}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
	driver.findElement(By.xpath("//button[@name='login']")).click();
	}
}
