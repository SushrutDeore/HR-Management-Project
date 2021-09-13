import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main_Class {
	
	public static void main(String[] args) {
		
		
		DAOClass obj=new DAOClass();
		obj.getConnection(); //Creating database Connection
		
		while(true)
		{
		System.out.println("1. Display All Department information");
		System.out.println("2. Display Salary information");
		System.out.println("3. Display Employee Contact");
		System.out.println("4.Add Employee details");
		System.out.println("5.Delete Employee");
		System.out.println("6.Search Employee");
		//System.out.println("7.Update Employee Details");
		System.out.println("8.Exit");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
				switch (choice) 
		{
		case 1:
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
		
		case 8:
			System.out.println("---Closing Connection---");
			obj.closeConnection();
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
