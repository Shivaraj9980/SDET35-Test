package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.Baseclass1;
@Listeners(genericUtility.ListenersImageClass.class)
public class Sample extends Baseclass1 {
	@Test
	public void sample()
	{
		System.out.println("abcde");
		Assert.assertEquals(false, true);
	}

}
