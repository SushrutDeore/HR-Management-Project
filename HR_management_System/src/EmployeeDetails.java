import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails {
	
	//To display Employee details from database
	public static void displayEmployeeContacts()
	{
		try {
			Statement st=DatabaseConnection.con.createStatement();
			String sql="select * from employee_information;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("Employee ID:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2)+" "+rs.getString(3));
				System.out.println("Phone Number:"+rs.getString(5));
				System.out.println("Email id:"+rs.getString(6));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
