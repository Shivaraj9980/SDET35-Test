package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class DataProviderWithExcel {
	public class DataProvidwerTest {

		@Test(dataProvider="bookticketdDataProvider")
		
		public void bookTicket(String src, String dst, String ticket)
		{
			System.out.println("Source is " +src+ " destination is  "+dst+"  numberof ticket is "+ ticket);
		}
	@DataProvider
	public Object[][] bookticketdDataProvider() throws Throwable
	{
		ExcelUtility excel=new ExcelUtility();
		String org = excel.getExceldata("Organisation", 0, 0);
		String org1 = excel.getExceldata("Organisation", 0, 1);
		String org2 = excel.getExceldata("Organisation", 0, 2);
		
		String pro = excel.getExceldata("Product", 0, 0);
		String pro1 = excel.getExceldata("Product", 0, 1);
		String pro2 = excel.getExceldata("Product", 0, 2);
		
		String ven = excel.getExceldata("Vendor", 0, 0);
		String ven1 = excel.getExceldata("Vendor", 0, 1);
		String ven2 = excel.getExceldata("Vendor", 0, 2);
	
		
		Object[][] obj= new Object[3][3];
		obj[0][0]= org;
		obj[0][1]= org1;
		obj[0][2]= org2;
		
		obj[1][0]= pro;
		obj[1][1]= pro1;
		obj[1][2]= pro2;
		
		obj[2][0]= ven;
		obj[2][1]= ven1;
		obj[2][2]= ven2;
		return obj;
		
	}
	}

}
