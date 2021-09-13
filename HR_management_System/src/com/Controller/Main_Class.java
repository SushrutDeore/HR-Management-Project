package com.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Bean.Admin;
import com.Configuration.ConnectionConfiguration;
import com.DAO.*;



public class Main_Class {
	
	public static void main(String[] args) {
		
		DAOClass obj=new DAOClass();
		
	
		while(true)
		{
		System.out.println();
		System.out.println();
		System.out.println("1. Display All Department information");
		System.out.println("2. Display Salary information");
		System.out.println("3. Display Employee Contact");
		System.out.println("4.Add Employee details");
		System.out.println("5.Delete Employee");
		System.out.println("6.Search Employee");
		System.out.println("7.Update Employee Salary");
		System.out.println("8.Department wise Employee list");
		System.out.println("9.Department wise employee count");
		System.out.println("10.Exit");
		System.out.println("Enter the Choice -->");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
				switch (choice) 
		{
		case 1:
			System.out.println("---Department Information---");
			obj.displayDepartmentInfo();// Displays All Department information 
			System.out.println("---------------");
			break;
			
		case 2:
			obj.displaySalaryInfo();//Display salary details.
			System.out.println("---------------");
			break;
			
		case 3:
			System.out.println("...Displaying All Employees Contact...");
			obj.displayEmployeeContacts();//Display employee info.
			System.out.println("---------------");
			break;
			
		case 4:
			System.out.println("...Add new record...");
			obj.addEmployee();//Add employee details to database
			System.out.println("---------------");
			
			break;
			
		case 5:
			System.out.println("...Deleting record...");
			System.out.println("Enter the Employee for ID");
			int empId=sc.nextInt();
			obj.deleteEmployeeRecord(empId);
			System.out.println("---------------");
			break;
		
		case 6:
			System.out.println("...Searching an  Employee by ID...");
			System.out.println("Enter the Employee Id");
			int empID=sc.nextInt();
			
			obj.searchEmpById(empID);
			System.out.println("---------------");
			break;
			
		case 7:
			System.out.println("...Updating Salary of employee...");
			System.out.println("Enter the Employee ID:");
			int id=sc.nextInt();
			System.out.println("Enter Salary:");
			double sal=sc.nextDouble();
			obj.updateSalary(id, sal);
			System.out.println("-------------------");
			break;
		
		case 8:
			int ch;
			System.out.println("Select the Department.");
			System.out.println("1.HR Department");
			System.out.println("2.Research and Developement Department");
			System.out.println("3.Accounts Department");
			System.out.println("4.Testing Department");
			System.out.println("5.Software Developement");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("---List of Employees From HR Department--- ");
				obj.listOfEmployeeFromDept(101);
				break;
			case 2:
				System.out.println("---List of Employees From Research and Developement Department--- ");
				obj.listOfEmployeeFromDept(102);
				break;
			case 3:
				System.out.println("---List of Employees From Accounts Department--- ");
				obj.listOfEmployeeFromDept(103);
				break;
			case 4:
				System.out.println("---List of Employees From Testing Department--- ");
				obj.listOfEmployeeFromDept(104);
				break;	
			case 5:
				System.out.println("---List of Employees From Software Developement Department--- ");
				obj.listOfEmployeeFromDept(105);
				break;
			}
			
			System.out.println("------------------");
			break;
			
		case 9:
			System.out.println();
			int ch1;
			System.out.println("Select the Department.");
			System.out.println("1.HR Department");
			System.out.println("2.Research and Developement Department");
			System.out.println("3.Accounts Department");
			System.out.println("4.Testing Department");
			System.out.println("5.Software Developement");
			ch1=sc.nextInt();
			int id1=100+ch1;
			obj.employeeCount(id1);
			break;
		case 10:
			System.out.println("---Closing Connection---");
			ConnectionConfiguration.closeConnection();
			sc.close();
			System.out.println("---------------");
			System.exit(0);
			break;
			
		
			
		default:
			System.out.println("Sorry for Inconvience");
			System.out.println("Try Again");
			
			
			
	
			
			
		}
		
		}
		
		
		
	}

}
