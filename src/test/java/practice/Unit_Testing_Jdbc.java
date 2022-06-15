package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Unit_Testing_Jdbc {
	public static void main(String [] args) throws SQLException
	{
		String projectname= "bbb";
		Connection conne = null;
		try {
			Driver dri= new Driver();
			DriverManager.registerDriver(dri);
			conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","root");
			System.out.println("connection is done");
			Statement stat = conne.createStatement();
			String query = "select*from attendance";
			ResultSet rs = stat.executeQuery(query);
			boolean flag=false;
			while(rs.next())
			{
				String actprojectname = rs.getString(3);
				if(actprojectname.equals(projectname))
				{
					flag=true;
					System.out.println("is  matching");
					System.out.println(actprojectname);
				}
			}	
			if(flag==false)
			{
				System.out.println("is not matching");
			}
		}


		catch(Exception e)
		{


		}
		finally {
			conne.close();
		}
	}



}
