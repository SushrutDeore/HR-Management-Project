package com.Bean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	
	public int id,deptId,experience;
	public String fname,lname,jdate,dob,role,branch,education,address,gender,adharno,nationality,email,phoneNo;
	public double salary;
	Scanner sc=new Scanner(System.in);
	
	//To set values for empolyee's Fields
	public void setEmployee()
	{
		
		System.out.println("Enter id");
		this.id=sc.nextInt();
		
		checkFname();
		
		checkLname();
		
		checkGender();
		
		System.out.println("Enter Education");
		this.education=sc.next();
		
		System.out.println("Enter address");
		this.address=sc.next();
		
		checkAdharNo();
		
		System.out.println("Enter nationality");
		this.nationality=sc.next();
		
		System.out.println("DOB");
		this.dob=sc.next();
		
		System.out.println("Enter Joining date:");
		this.jdate=sc.next();
		
		System.out.println("enter department id");
		this.deptId=sc.nextInt();
		
		System.out.println("Enter role");
		this.role=sc.next();
		
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
	
	public void getEmployee()
	{
		System.out.println();
		
		System.out.println("...............................");
		System.out.println("Employee Id:"+this.id);
		
		System.out.println("First name: "+this.fname);
		
		System.out.println("Last name: "+this.lname);
		
		System.out.println("Gender: "+this.gender);
		
		System.out.println("Phone No : "+this.phoneNo);
		
		System.out.println("Email Id : "+this.email);
		
		System.out.println("Education: "+this.education);
		
		System.out.println("Address : "+this.address);
		
		System.out.println("Aadhar no : "+this.adharno);
		
		System.out.println("Nationality :"+this.nationality);
		
		System.out.println("DOB : "+this.dob);
		
		System.out.println("Joining date : "+this.jdate);
		
		System.out.println("Department id: "+this.deptId);
		
		System.out.println("Role : "+this.role);
		
		System.out.println("Branch : "+this.branch);
		
		System.out.println("Experience : "+this.experience);
		
		System.out.println("Salary : INR "+this.salary);
		System.out.println();
		System.out.println("...............................");
			
	}
	
	public void setEmployeeFromDB(ResultSet rs)
	{
	try 
	{
		this.id=rs.getInt(1);
		this.fname=rs.getString(2);
		this.lname=rs.getString(3);
		this.jdate=rs.getString(4);
		this.phoneNo=rs.getString(5);
		this.email=rs.getString(6);
		this.gender=rs.getString(7);
		this.salary=rs.getDouble(8);
		this.deptId=rs.getInt(9);
		this.role=rs.getString(10);
		this.branch=rs.getString(11);
		this.dob=rs.getString(12);
		this.education=rs.getString(13);
		this.address=rs.getString(14);
		this.experience=rs.getInt(15);
		this.adharno=rs.getString(16);
		this.nationality=rs.getString(17);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	//for validation of phone number
	public boolean phoneValidation(String no)
	{
		Pattern p=Pattern.compile("[7-9][0-9]{9}");
		Matcher m=p.matcher(no);
		
		return (m.find() && m.group().equals(no));
	}
	
	//for validating email id
	public  boolean emailValidation(String email) 
	{
		Pattern p=Pattern.compile("^(.+)@(.+)com");
		Matcher m=p.matcher(email);
		
		return(m.matches());
	}
	
	//Check for email is valid and set the value.
	public void checkEmail()
	{
		System.out.println("Enter email id:");
		String emailId=sc.next();
		if(this.emailValidation(emailId))
			this.email=emailId;
		else
		{
			System.out.println("Enterd value is invalid");
			checkEmail();
		}
	}
	
	//Check for phone number is valid and set the value.
	public void checkPhoneNo()
	{
		System.out.println("Enter Phone number:");
		String no=sc.next();
		if(this.phoneValidation(no))
			this.phoneNo=no;
		else
			checkPhoneNo();
	}
	
	//For validating Strings which contains only Character value.
	public boolean validateName(String name) 
	{
		String regex= "^[A-Z][A-Za-z]+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(name);
		return m.matches();
					
	}
	
	//Check for First name and set value.
	public void checkFname()
	{
		System.out.println("Enter First name:");
		String name=sc.next();
		if(this.validateName(name))
			this.fname=name;
		else
		{
			System.out.println("Invalid");
			checkFname();
		}
			
	}
	
	//Check for Last name and set value.
	    public void checkLname()
		{
		System.out.println("Enter Last name:");
		String name=sc.next();
		if(this.validateName(name))
			this.lname=name;
		else
		{
			System.out.println("Invalid");
			checkLname();
		}
		}
		
		
	
	//Check For Gender value.
	public void checkGender()
	{
		System.out.println("Enter Gender");
		String gender=sc.next();
		if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))
			this.gender=gender;
		else
		{
			System.out.println("Invalid Value \n Enter Again");
			checkGender();
		}
			
		
	}
	
	
	//Validating adhar no
	public void checkAdharNo()
	{
		System.out.println("Enter Adhar Number:");
		String no=sc.next();
		
		if(no.length()==12 && no.charAt(0)!='0')
			this.adharno=no;
		else
		{
			System.out.println("Invalid");
			checkAdharNo();
		}
		
	}
	

			
		
		
		
		
		
		
		
		
	}


