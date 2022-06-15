package gridsetup;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridRemote
{
	@Test
	public void rungridRemote() throws Throwable
	{
		URL url = new URL("http://192.168.43.44:5556/wd/hub");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		RemoteWebDriver driver =new RemoteWebDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://facebook.com");
	}
}
