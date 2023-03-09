package util;

import java.sql.*;

public class DBConnection 
{
//	 follows 5 steps ---Database Connection
	
	// 1) Make Credentials
	private static final String URLNAME="jdbc:mysql://localhost:3306/rpl2023";
	private static final String DRIVERCLASS="com.mysql.cj.jdbc.Driver";
	private static final String USERNAME="root";
	private static final String PASSWORD="";

	// 2) create getConnection method
	public static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			// 3) Load Driver Class
			Class.forName(DRIVERCLASS);
			
			// 4) pass credential into DriverManager's getConnection Method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) 
	{
		System.out.println("DBConnection : " + DBConnection.getConnection());
		
	}
}
