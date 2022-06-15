package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidwerTest {

	@Test(dataProvider="bookticketdDataProvider")
	
	public void bookTicket(String src, String dst, int ticket)
	{
		System.out.println("Source is " +src+ " destination is  "+dst+"  numberof ticket is "+ ticket);
	}
@DataProvider
public Object[][] bookticketdDataProvider()
{
	Object[][] obj= new Object[3][3];
	obj[0][0]= "Bangalore";
	obj[0][1]= "Mysore";
	obj[0][2]= 10;
	
	obj[1][0]= "Bangalore";
	obj[1][1]= "goa";
	obj[1][2]= 20;
	
	obj[2][0]= "Bangalore";
	obj[2][1]= "Chikkamgakuru";
	obj[2][2]= 5;
	return obj;
}
}
