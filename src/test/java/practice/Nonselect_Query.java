package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselect_Query {
	public static void main (String[] args) throws SQLException
	{
	
	Connection conn=null;
	
	int result=0;
	try{
		// register to database
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	//get connection
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1", "root", "root");
	
	//write query
	Statement stat = conn.createStatement();
	String query = "insert into students2 values('01','shivu','raj','C')";
	
	//execute query;
	result=stat.executeUpdate(query);
	}
	catch (Exception e) 
	{
	
	}
	finally {
		if(result==1)
		{
			System.out.println("inserted");
		
		}
		else
		{
			System.out.println("not inserted");
		}
		
		conn.close();
	}

}
}
