package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass1;
@Listeners(com.crm.comcast.genericUtility.ListenersImageClass.class)
//asdfgff
public class Sample extends Baseclass1 {
	@Test
	public void sample()
	{
		System.out.println("abcde");
		Assert.assertEquals(false, true);
	}

}
