package gridsetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteExecution {

	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("http://192.168.43.44:5556/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		RemoteWebDriver driver= new RemoteWebDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://gmail.com");
		driver.getTitle();
	}

}
