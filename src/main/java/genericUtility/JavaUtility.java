package genericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to add random number to string
	 * created by shivu
	 * 
	 */
	public int getRandomNum()
	{
	Random ran= new Random(); 
	int randomInt = ran.nextInt(50);
	return randomInt;
	}
	
	/**
	 *  its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */
		public String  getDate() {
			String time = LocalDateTime.now().toString().replace(":", "-");
			return time;
			
//		Date date = new Date();
//		String date1 = date.toString();
//		System.out.println(date1);
//		String[] arr = date1.split("");
//		String yyyy = arr[5];
//		String dd = arr[2];
//		int mm = date.getMonth()+1;
//		String formate = dd+"_"+mm+"_"+yyyy;
//		//String currentdate = date1.replace(";", "-");
//		return formate;
//			
	}

		
}
