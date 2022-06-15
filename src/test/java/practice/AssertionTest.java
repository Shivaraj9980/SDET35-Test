package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AssertionTest {
	@Test
	public void test1()
	{
		System.out.println("test1");
		System.out.println("test2");
		Assert.assertEquals(1, 2);
		System.out.println("test3");
		System.out.println("test4");
	}
	@Test
	public void test2()
	{
		System.out.println("test5");
		System.out.println("test6");
		System.out.println("test7");
		System.out.println("test8");
	}


}
