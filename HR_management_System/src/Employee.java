import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	
	public int id,deptId,experience;
	public String fname,lname,jdate,dob,position,branch,education,address,gender,adharno,nationality,email,phoneNo;
	public double salary;
	Scanner sc=new Scanner(System.in);
	
	//To set values for empolyee's Fields
	public void setEmployee()
	{
		System.out.println("Enter id");
		this.id=sc.nextInt();
		System.out.println("Enter First name:");
		this.fname=sc.next();
		System.out.println("Enter Last name:");
		this.lname=sc.next();
		System.out.println("Enter Gender");
		this.gender=sc.next();
		System.out.println("Enter Education");
		this.education=sc.next();
		System.out.println("Enter address");
		this.address=sc.next();
		System.out.println("Enter adhar no");
		this.adharno=sc.next();
		System.out.println("Enter nationality");
		this.nationality=sc.next();
		System.out.println("DOB");
		this.dob=sc.next();
		System.out.println("Enter Joining date:");
		this.jdate=sc.next();
		System.out.println("enter department id");
		this.deptId=sc.nextInt();
		System.out.println("Enter position");
		this.position=sc.next();
		System.out.println("Enter branch");
		sc.nextLine();
		this.branch=sc.next();
		
		System.out.println("Enter experience");
		this.experience=sc.nextInt();
		System.out.println("Enter  Salary");
		this.salary=sc.nextDouble();
		
		checkEmail();
		checkPhoneNo();
		
			
	}
	
	public void checkEmail()
	{
		System.out.println("Enter email id:");
		String emailId=sc.next();
		if(Validation.emailValidation(emailId))
			this.email=emailId;
		else
			checkEmail();
	}
	
	public void checkPhoneNo()
	{
		System.out.println("Enter Phone number:");
		String no=sc.next();
		if(Validation.phoneValidation(no))
			this.phoneNo=no;
		else
			checkPhoneNo();
	}
	
	//Add entry to database
	public static boolean addEmployee()
	{
		try {
		String sql="insert into employee_information values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=DatabaseConnection.con.prepareStatement(sql);
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
		ps.setString(10, e.position);
		ps.setString(11, e.branch);
		ps.setString(12, e.dob);
		ps.setString(13, e.education);
		ps.setString(14, e.address);
		ps.setInt(15, e.experience);
		ps.setString(16, e.adharno);
		ps.setString(17, e.nationality);
		
		boolean a=ps.execute();
		Salary.setSalary();
		
		return a;
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return  true;
		}
		
		
		
	}
	

			
		
		
		
		
		
		
		
		
	}


