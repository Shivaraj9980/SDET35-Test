package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselect_Query3 {
	public static void main (String[] args) throws SQLException
	{
		Connection connect1=null;
		int rs1=0;
	try
	{
		// register to database
	Driver dri1 = new Driver();
	DriverManager.registerDriver(dri1);
	 connect1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1", "root", "root");		
	 Statement stat = connect1.createStatement();
	 String query = "update students2 values('03','RRR','ttt','yyy')";
	 rs1 = stat.executeUpdate(query);
	}
	
	catch (Exception e)
	{
		
	}
	finally {
		if(rs1==1)
		{
			System.out.println(" Inserted succesfully");
	}
		else 
		{
			System.out.println("Not inserted succesfully");
		}
		connect1.close();
	
}
	}
}



