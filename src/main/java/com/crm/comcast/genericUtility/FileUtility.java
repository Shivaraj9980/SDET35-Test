package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to get the key and value from Property file
	 * created by shivu
	 * @param string 
	 * 
	 */
	
	public String getKeyandValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(Constants.propertyfilePath);
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		
		return value;
	}
	}