import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DatabaseConnection {
	
	public static final String driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/hr_management_system";
	public static Connection con=null;
	
	public static void getConnection()
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id");
			String id=sc.next();
			System.out.println("Enter the Password:");
			String psw=sc.next();
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,psw);
			System.out.println("Connected successfully....");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Connection");
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try
		{
		con.close();
		System.out.println("Connection closed.....");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
