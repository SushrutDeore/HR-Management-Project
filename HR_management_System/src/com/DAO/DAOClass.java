package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Bean.Admin;
import com.Bean.Employee;
import com.Configuration.ConnectionConfiguration;

public class DAOClass implements DAOInterface
{
	private  Connection con=ConnectionConfiguration.connect();
	
	
	public Admin loginCredentials()
	{
		String sql="select * from admin";
		Admin admin=new Admin();
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				admin.setId(rs.getInt(1));
				admin.setPsw(rs.getString(2));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return admin;
	}

	
	public boolean addEmployee() //Add new Entry to Employee_information table.
	{
		
		try {
			String sql="insert into employee_information values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=this.con.prepareStatement(sql);
			Employee e=new Employee();
			e.setEmployee();
			ps.setInt(1, e.id);
			ps.setString(2, e.fname);
			ps.setString(3, e.lname);
			ps.setString(4, e.jdate);
			ps.setString(5, e.phoneNo);
			ps.setString(6, e.email);
			ps.setString(7, e.gender);
			ps.setDouble(8, e.salary);
			ps.setInt(9, e.deptId);
			ps.setString(10, e.role);
			ps.setString(11, e.branch);
			ps.setString(12, e.dob);
			ps.setString(13, e.education);
			ps.setString(14, e.address);
			ps.setInt(15, e.experience);
			ps.setString(16, e.adharno);
			ps.setString(17, e.nationality);
			
			boolean a=ps.execute();
			
			this.setSalary();
			
			return a;
			
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				return  true;
			}
			
	}
	
	
	public  void displayEmployeeContacts()
	{
		try {
			Statement st=con.createStatement();
			String sql="select * from employee_information;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("___________________");
				System.out.println();
				System.out.println("Employee ID:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2)+" "+rs.getString(3));
				System.out.println("Phone Number:"+rs.getString(5));
				System.out.println("Email id:"+rs.getString(6));
				System.out.println();
				System.out.println("___________________");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	public void displayDepartmentInfo() 
	{
		try {
			Statement st=con.createStatement();
			String sql="select * from department";
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Department Id "+"\t"+"Department name ");
			System.out.println();
			System.out.println("______________________");
			System.out.println();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2));
			}
			System.out.println();
			System.out.println("______________________");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public void displaySalaryInfo()
	{
		try {
			Statement st=con.createStatement();
			String sql="select e.emp_id,emp_fname,emp_lname,salary from employee_information e inner join salary_details s on e.emp_id=s.emp_id;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("--------");
				System.out.println("EmpId:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2)+" "+rs.getString(3));
				System.out.println("Salary: INR "+rs.getDouble(4));
				System.out.println("---------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	
	public int getIndex() 
	{
		int index=0;
		try
		{
			String sql="select emp_id from employee_information  order by emp_id desc limit 1";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				index=rs.getInt(1);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return index;


	}

	
	public void setSalary() 
	{
		
		int index=this.getIndex();
		if(index!=0)
		{	
		try
		{
			
		String sql="select emp_id,dept_id,salary from employee_information where emp_id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, index);
		ResultSet rs=ps.executeQuery();
		String query="insert into salary_details values(?,?,?)";
		PreparedStatement ps2=con.prepareStatement(query);
		
		while(rs.next())
		{
			//Salary s=new Salary(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			ps2.setInt(1, rs.getInt(1));
			ps2.setInt(2, rs.getInt(2));
			ps2.setDouble(3, rs.getDouble(3));
			ps2.execute();
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		else
			System.out.println("Error");
				
	}


	public void deleteEmployeeRecord(int empId) 
	{
		String sql="delete ei,sd from salary_details sd inner join employee_information ei on ei.emp_id=sd.emp_id where ei.emp_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, empId);
			boolean flag=ps.execute();
			if(flag==false)
				System.out.println("Record deleted Successfully.");
			else
				System.out.println("Error Occurred...!");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	
	public void searchEmpById(int empId) // Get Employee information of provided empID 
	{
		
		Employee emp=new Employee();
		String sql="select * from employee_information where emp_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, empId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			emp.setEmployeeFromDB(rs);	
			}
			emp.getEmployee();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	public void updateSalary(int empId, double Salary) 
	{
		String sql="update employee_information ei inner join salary_details sd on ei.emp_id=sd.emp_id  set ei.salary=?,sd.monthly_salary=? where ei.emp_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, Salary);
			ps.setDouble(2, Salary);
			ps.setInt(3, empId);
			int a=ps.executeUpdate();
			System.out.println(a+" Rows Updated");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Unable to update");
		}
	}
	
	public void listOfEmployeeFromDept(int deptId)
	{
		Employee e=new Employee();
		String sql="select * from employee_information where dept_id=?;";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, deptId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				e.setEmployeeFromDB(rs);
				e.getEmployee();
				
			}
			
			
		}
		catch (Exception e1) {
			// TODO: handle exception
			System.out.println("Error");
			e1.printStackTrace();
		}
	}

	public void employeeCount(int deptId)
	{
		String sql="select department_name,count(*) from employee_information ei inner join department d on d.department_id=ei.dept_id where ei.dept_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, deptId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getString(1)+"Department  has "+rs.getInt(2)+" Employee.");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	
}
