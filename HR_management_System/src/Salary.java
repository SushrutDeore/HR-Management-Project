import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Salary {
	
	public int empId,deptId;
	public double salary;
	
	
	
	public Salary(int empId, int deptId, double salary) {
		super();
		this.empId = empId;
		this.deptId = deptId;
		this.salary = salary;
	}

	//for getting salary details of employee
	public static void displaySalaryInfo()
	{
		
		try {
			Statement st=DatabaseConnection.con.createStatement();
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
	
	public static void setSalary()
	{
		int index=Salary.getIndex();
		if(index!=0)
		{	
		try
		{
			
		String sql="select emp_id,dept_id,salary from employee_information where emp_id=?";
		
		PreparedStatement ps=DatabaseConnection.con.prepareStatement(sql);
		ps.setInt(1, index);
		ResultSet rs=ps.executeQuery();
		String query="insert into salary_details values(?,?,?)";
		PreparedStatement ps2=DatabaseConnection.con.prepareStatement(query);
		
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
	
	public static int getIndex()
	{
		int index=0;
		try
		{
			String sql="select emp_id from employee_information  order by emp_id desc limit 1";
			PreparedStatement ps=DatabaseConnection.con.prepareStatement(sql);
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
	
	
			
		
		
	

}
