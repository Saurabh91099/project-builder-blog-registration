package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation{
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validEmail(email) && validPassword(password, confirmPassword))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		
	}
	private boolean validPassword(String password, String confirmPassword) {
		if (password == null || confirmPassword==null) 
            return false; 
		else {
			 
			 String format= "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=\\S+$).{8,20}$";
			 Pattern p = Pattern.compile(format); 
			  Matcher m = p.matcher(password); 
  
		        
		        boolean validPassword1=m.matches(); 
		        if(validPassword1 && (password.contentEquals(confirmPassword)))
		        {
		        	return true;
		        }
		        else {
		        	return false;
				}
		        
		}
		
	}
	private boolean validEmail(String email) {
		String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		Pattern p = Pattern.compile(emailReg); 
		if (email == null) 
			return false; 
		return p.matcher(email).matches();
		
		
	}
}