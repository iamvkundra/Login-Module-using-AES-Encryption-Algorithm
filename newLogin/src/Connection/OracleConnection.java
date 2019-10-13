package Connection;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
public class OracleConnection {

	Connection con;
	Statement str;
	ResultSet rs;
	PreparedStatement pst;
	public void connect()
	{
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:"+ "@localhost:1521:XE","system","mummy1234");
			
			//str=(Statement) con.createStatement();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String executeLogin(String username)
	{
		connect();
		
		String pass1="";
		try
		{
			pst = con.prepareStatement("SELECT * FROM UserLoginNew where userId =?");
			pst.setString(1, username);
			rs= pst.executeQuery();
			while(rs.next())
			{
				pass1=rs.getString(2);
			}
			
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return pass1;
	}
	public boolean InsertAccount(String username, String password) 
	{
		connect();
		try
		{
		String insert1 ="insert into UserLoginNew  values(?,?)";
		pst= con.prepareStatement(insert1);
		pst.setString(1, username);
		pst.setString(2, password);
		rs = pst.executeQuery();
		con.close();
	
		return true;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}

	
}
