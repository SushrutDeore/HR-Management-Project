import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main_Class {
	
	public static void main(String[] args) {
		
		
		
		DatabaseConnection.getConnection(); //Creating database Connection
		while(true)
		{
		System.out.println("1. Display All Department information");
		System.out.println("2. Display Salary information");
		System.out.println("3. Display Employee Contact");
		System.out.println("4.Add Employee details");
		//System.out.println("5.Delete Employee");
		//System.out.println("6.Search Employee");
		//System.out.println("7.Update Employee Details");
		System.out.println("8.Exit");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
	
		switch (choice) 
		{
		case 1:
			Department.displayDepartmentInformation();// Displays All Department information 
			System.out.println("---------------");
			break;
			
		case 2:
			Salary.displaySalaryInfo();//Display salary details.
			System.out.println("---------------");
			break;
			
		case 3:
			EmployeeDetails.displayEmployeeContacts();//Display employee info.
			System.out.println("---------------");
			break;
			
		case 4:
			Employee.addEmployee();//Add employee details to database
			System.out.println("---------------");
			break;
		
		case 8:
			DatabaseConnection.closeConnection();
			
			System.exit(0);
			
		default:
			System.out.println("Sorry for Inconvience");
			
			
			
	
			
			
		}
		
		}
		
		
		
	}

}
