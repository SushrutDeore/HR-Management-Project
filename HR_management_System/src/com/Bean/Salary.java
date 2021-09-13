package com.Bean;


public class Salary{
	
	private int empId,deptId;
	private double salary;
	
	public Salary()
	{
		
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Salary(int empId, int deptId, double salary)
	{
		super();
		this.empId = empId;
		this.deptId = deptId;
		this.salary = salary;
	}

	

	
	
			
		
		
	

}
