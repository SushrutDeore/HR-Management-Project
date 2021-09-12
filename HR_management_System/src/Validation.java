import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
//for validation of phone number	
	public static boolean phoneValidation(String no)
	{
		Pattern p=Pattern.compile("[7-9][0-9]{9}");
		Matcher m=p.matcher(no);
		
		return (m.find() && m.group().equals(no));
	}
	
	//for validating email id
	public static boolean emailValidation(String email) 
	{
		Pattern p=Pattern.compile("^(.+)@(.+)com");
		Matcher m=p.matcher(email);
		
		return(m.matches());
	}
	
	

}
