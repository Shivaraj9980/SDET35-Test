package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
public void softAssertTest1()
	{
		System.out.println("test1");
		System.out.println("test2");
		SoftAssert sa= new SoftAssert();
		sa.assertEquals("abc", "sds");
		System.out.println("test3");
		System.out.println("test4");
		sa.assertAll();
	}
	@Test
	public void softAssertTest2()
		{
			System.out.println("test5");
			System.out.println("test6");
			System.out.println("test7");
			System.out.println("test8");
		}
}
