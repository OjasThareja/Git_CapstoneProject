package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_Update 
{
	String url;
	String username;
	String password;
	Connection con;
	PreparedStatement stmt;
	public void updateDB(String name, int quantity) throws ClassNotFoundException, SQLException
	{
		url = "jdbc:mysql://localhost:3306/medicare";
		username = "root";
		password = "MySQL1881Root";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		stmt=con.prepareStatement("update product set quantity=? where name=?;"); 
		stmt.setInt(1, quantity);
		stmt.setString(2, name);
		stmt.executeUpdate();
		con.close();
		
	}

}
