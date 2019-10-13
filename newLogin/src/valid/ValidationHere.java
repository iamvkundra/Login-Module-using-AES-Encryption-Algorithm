package valid;

import Connection.OracleConnection;
import passEnc.PasswordEnc;

public class ValidationHere {
	
	public boolean  validLogin(String username, String password)
	{
		OracleConnection x = new OracleConnection();
		PasswordEnc v= new PasswordEnc();
		String dataPass = x.executeLogin(username);
		String newPass = v.dec(dataPass);
		
		if(password.equals(newPass))
		{
			
			return true;
		}
		return false;		
	}
	public boolean register(String username, String password)
	{
		OracleConnection x = new OracleConnection();
		boolean b= x.InsertAccount(username,password);
		
		if(b)
		{
			return true;
		}
		return false;
	}
	

}
