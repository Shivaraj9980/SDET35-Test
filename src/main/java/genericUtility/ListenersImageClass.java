package genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImageClass implements ITestListener 
{
public void onTestFailure(ITestResult result)
{
	JavaUtility javautil = new JavaUtility();
	String methodName = result.getMethod().getMethodName();
	EventFiringWebDriver edriver= new EventFiringWebDriver(Baseclass1.sdriver);
	File src = edriver.getScreenshotAs(OutputType.FILE);
	System.out.println(javautil.getDate());
	File dst = new File("./screenshot/"+methodName+"_"+javautil.getDate()+".png");
	
	try {
		org.openqa.selenium.io.FileHandler.copy(src, dst);
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}
}
	
	


//public void onTestSuccess(ITestResult result) {
//    // not implemented
//  }
//
//
//public void onTestStart(ITestResult result) {
//}
//}
