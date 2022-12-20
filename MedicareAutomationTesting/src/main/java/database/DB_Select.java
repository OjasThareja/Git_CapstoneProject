package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Select 
{
	String url;
	String username;
	String password;
	Connection con;
	Statement stmt;
	public String data;
	public ResultSet rs;
	public String retrieveData(String query) throws ClassNotFoundException, SQLException
	{
		url = "jdbc:mysql://localhost:3306/medicare";
		username = "root";
		password = "MySQL1881Root";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		stmt = con.createStatement();
		//rs=stmt.executeQuery("select id from cart;");
		//rs.next();
		//System.out.println(rs.getInt("id"));
		
		rs =stmt.executeQuery(query); 
	
		if(rs.next())
		{
			data = rs.getString("name");
		}
		else
		{
			data="Data Not Found";
		}
		con.close();
		return data;
	}

}
