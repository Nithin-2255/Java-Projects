package LOGIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// CONNECTION FOR ALL DATABASE OPERATIONS

public class DBconnection 
{
	public static Statement stmt=null;
	public static Statement createStmt()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","2255");
			stmt=con.createStatement();
			
		} catch (Exception e) 
		
		{
			System.out.println(e);
		}
		return stmt;
	}
}
