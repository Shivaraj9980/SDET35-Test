package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_AddOrganisation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.xpath("//a[.='Organizations']/../../td[6]")).click();
				driver.findElement(By.xpath("//img[@alt='Create Organization...\']")).click();
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("abcdefg");
				driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
				WebDriverWait wait=new WebDriverWait(driver, 3);
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				String abc = alert.getText();
				System.out.println(abc);
				alert.accept();
				Thread.sleep(3000);
				driver.quit();
				
				

	}

}
