package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///C:/Users/admin/Desktop/simple111.html");
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("shivu");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('lname').value='ADFHADH'");
		Thread.sleep(2000);

		js.executeScript("alert('Welcome To WORLD')");

		WebdriverUtility web = new WebdriverUtility();
		Thread.sleep(2000);
		web.swithToAlertWindowAndAccpect(driver, "Welcome To WORLD");


	}


}
