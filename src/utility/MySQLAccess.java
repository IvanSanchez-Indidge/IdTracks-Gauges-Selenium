package utility;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAccess
{
	private Connection connect = null;
	private ResultSet resultSet;
	
	private String dbConnection = "jdbc:mysql://aa1pfjb4qfwd516.crnsandnwdyy.us-west-1.rds.amazonaws.com:3306/ebdb";
	private String dbUser = "gauges";
	private String dbPassword = "Indidge$1";
	
	public void deleteSeleniumUser(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			resultSet = connect.prepareStatement("SELECT user_id FROM user where email_addr = '" + email + "'").executeQuery();
			resultSet.next();
			
			int user_id = resultSet.getInt("user_id");
			
			connect.prepareStatement("DELETE FROM user_role WHERE user_id = '" + user_id + "'").executeUpdate();
			connect.prepareStatement("DELETE FROM user WHERE email_addr = '" + email + "'").executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
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
		
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			connect.prepareStatement("DELETE FROM location WHERE location_name = '" + location_name + "'").executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
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
		
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			connect.prepareStatement("DELETE FROM trace WHERE item_id = '" + item_id + "'").executeUpdate();
			connect.prepareStatement("DELETE FROM item WHERE item_id = '" + item_id + "'").executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
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
		
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			resultSet = connect.prepareStatement("SELECT pm_id FROM pm where item_id = " + item_id + "'").executeQuery();
			resultSet.next();
			
			int pm_id = resultSet.getInt("pm_id");
			
			connect.prepareStatement("DELETE FROM pm_measure WHERE pm_id = '" + pm_id + "'").executeUpdate();
			connect.prepareStatement("DELETE FROM pm WHERE item_id = '" + item_id + "'").executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		finally
		{
			connect.close();
		}
	}
}