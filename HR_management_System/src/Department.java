import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
	
	public static void displayDepartmentInformation()
	{
		try {
			Statement st=DatabaseConnection.con.createStatement();
			String sql="select * from department";
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Department Id "+"\t"+"Department name ");
			System.out.println();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
