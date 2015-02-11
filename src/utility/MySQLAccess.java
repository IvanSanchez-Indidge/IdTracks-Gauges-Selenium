package utility;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAccess
{
	private Connection connect = null;
	private ResultSet resultSet = null;
	
	private String dbConnection = "aa1pfjb4qfwd516.crnsandnwdyy.us-west-1.rds.amazonaws.com:3306/";
	private String dbName = "ebdb";
	private String dbUser = "user=gauges";
	private String dbPassword = "password=Indidge$1";
	
	public void deleteSeleniumUser(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
			connect = DriverManager.getConnection(dbConnection + dbName + dbUser + "&" + dbPassword);
			
			resultSet = connect.prepareStatement("SELECT user_id FROM users where email_addr = " + email).executeQuery();
			
			int user_id = resultSet.getInt("user_id");
			
			connect.prepareStatement("DELETE FROM user_role WHERE user_id = " + user_id).executeUpdate();
			connect.prepareStatement("DELETE FROM user WHERE email_addr = " + email).executeUpdate();
		}
		finally
		{
			connect.close();
		}
	}
	
	public void deleteSeleniumLocation(String location_name) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
			connect = DriverManager.getConnection(dbConnection + dbName + dbUser + "&" + dbPassword);
			
			connect.prepareStatement("DELETE FROM location WHERE location_name = " + location_name).executeUpdate();
		}
		finally
		{
			connect.close();
		}
	}
	
	public void deleteSeleniumItem(String item_id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
			connect = DriverManager.getConnection(dbConnection + dbName + dbUser + "&" + dbPassword);
			
			connect.prepareStatement("DELETE FROM trace WHERE item_id = " + item_id).executeUpdate();
			connect.prepareStatement("DELETE FROM item WHERE item_id = " + item_id).executeUpdate();
		}
		finally
		{
			connect.close();
		}
	}
	
	public void deleteSeleniumPM(String item_id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
			connect = DriverManager.getConnection(dbConnection + dbName + dbUser + "&" + dbPassword);
			
			resultSet = connect.prepareStatement("SELECT pm_id FROM pm where item_id = " + item_id).executeQuery();
			
			int pm_id = resultSet.getInt("pm_id");
			
			connect.prepareStatement("DELETE FROM pm_measure WHERE pm_id = " + pm_id).executeUpdate();
			connect.prepareStatement("DELETE FROM pm WHERE item_id = " + item_id).executeUpdate();
		}
		finally
		{
			connect.close();
		}
	}
}