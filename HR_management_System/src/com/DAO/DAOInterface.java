package com.DAO;

import java.sql.Connection;

import com.Bean.Admin;

interface DAOInterface {

	public Admin loginCredentials();//
	
	public boolean addEmployee();//Add new Entry to Employee_information table.
	
	public void displayDepartmentInfo();//Display records of Department table.
	
	public void displaySalaryInfo();//Display Salary along with Name.
	
	public int getIndex();//Get id of last inserted record.
	
	public  void setSalary();//Updating salary to salary table from employee Infromation.
	
	public void deleteEmployeeRecord(int empId);//Delete from Employee and Slary table.
	
	public void searchEmpById(int empId);//Search Employee Record From Employee_Information.
	
	public void updateSalary(int empId,double Salary);//Update value of salary.
	
	public void listOfEmployeeFromDept(int deptId);//List of employees Department wise
	
	public void employeeCount(int deptId);//Count of employees from specific department
	
	
	
}
