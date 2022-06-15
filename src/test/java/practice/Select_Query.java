package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Select_Query {
	
	public static void main (String[] args) throws SQLException
	{
	
	Connection conn=null;
	
	try{
		// register to database
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	//get connection
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1", "root", "root");
	
	//write query
	Statement stat = conn.createStatement();
	String query = "select * from attendance";
	
	//execute query;
	ResultSet result = stat.executeQuery(query);

	while(result.next())
	{
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
	}}
	catch (Exception e) 
	{
	
	}
	finally 
	{
		conn.close();
	}
	}
}

	
	
	
	


