
 interface DAOInterface {

	public void getConnection();//Establishing connection from database.
	
	public void closeConnection();
	
	public boolean addEmployee();//Add new Entry to Employee_information table.
	
	public void displayDepartmentInfo();//Display records of Department table.
	
	public void displaySalaryInfo();//Display Salary along with Name.
	
	public int getIndex();//Get id of last inserted record.
	
	public  void setSalary();//Updating salary to salary table from employee Infromation.
	
	public void deleteEmployeeRecord(int empId);//Delete from Employee and Slary table.
	
	public void searchEmpById(int empId);//Search Employee Record From Employee_Information.
	
	
	
}
