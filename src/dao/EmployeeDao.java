package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import bean.EmployeeBean;
import util.DBConnection;

public class EmployeeDao 
{
	public int insert(EmployeeBean ebean) 
	{
		String insertQuery = "INSERT INTO Employee(name,salary,dsgn) VALUES(?,?,?)";
		
		// insert Query---Database connection object
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int  rowAffected = 0;
		if (conn!=null) 
		{
			
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, ebean.getName());
				pstmt.setInt(2, ebean.getSalary());
				pstmt.setString(3, ebean.getDsgn());
				
				rowAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not Conneected : " + conn);
		}
		return rowAffected;
	}
	public void update() 
	{

	}
	public void delete() 
	{

	}
	public void getAllRecords() 
	{

	}
	public static void main(String[] args) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Salary : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Dsgn : ");
		String dsgn = sc.nextLine();
		
		
		EmployeeBean ebean = new EmployeeBean();
		
		ebean.setName(name);
		ebean.setSalary(salary);
		ebean.setDsgn(dsgn);
		
		EmployeeDao dao = new EmployeeDao();
		
		
		int rowAffected = dao.insert(ebean);
		
		if (rowAffected > 0 ) 
		{
			System.out.println("Employee records succesfully Inserted : " + rowAffected);
		} else 
		{
			System.out.println("Employee records not Inserted : " + rowAffected);
		}
	}
}
