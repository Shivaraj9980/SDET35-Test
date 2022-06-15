package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselect_Query2 {
	public static void main (String[] args) throws SQLException
	{
		Connection connect=null;
		int rs=0;
	try
	{
		// register to database
	Driver dri = new Driver();
	DriverManager.registerDriver(dri);
	 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1", "root", "root");		
	 Statement stat = connect.createStatement();
	 String query = "insert into students2 values('03','rrr','ttt','yyy')";
	 rs = stat.executeUpdate(query);
	}
	
	catch (Exception e)
	{
		
	}
	finally {
		if(rs==1)
		{
			System.out.println(" Inserted succesfully");
	}
		else 
		{
			System.out.println("Not inserted succesfully");
		}
		connect.close();
	
}
	}
}
