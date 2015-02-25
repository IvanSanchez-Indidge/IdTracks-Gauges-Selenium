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
	
	public void createSeleniumStoreItem(String itemName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			connect.prepareStatement("INSERT INTO user (first_name, last_name, email_addr, contact, company_name, department, password, expired, locked, enabled, password_expired) "
					+ "VALUES ('Selenium Test User', 'Selenium Test User', 'stu@abc.com', '321-654-9871', 'Test Company', 'Test', '$2a$10$D8eImRhdH/1H4uL80N2SouLpg6X3d5nsQ8rRcah8/wO.XfzwyRKBq', 0, 0, 1, 0)").executeUpdate();
			
			String email = "stu@abc.com";
			resultSet = connect.prepareStatement("SELECT user_id FROM user where email_addr = '" + email + "'").executeQuery();
			resultSet.next();
			
			int user_id = resultSet.getInt("user_id");
			/*
			System.out.println(user_id);
			connect.prepareStatement("INSERT INTO user_role (user_id, role_id) "
					+ "VALUES (" + user_id + ", 1").executeUpdate();
			*/
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Store', 'Location Selenium Test Store', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Store', 'N/A', 'Store', 'Active')").executeUpdate();
			
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Factory', 'Location Selenium Test Factory', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Factory', 'N/A', 'Factory', 'Active')").executeUpdate();
			
			resultSet = connect.prepareStatement("SELECT location_id FROM location where location_name = 'Location Selenium Test Store'").executeQuery();
			resultSet.next();
			
			String location_id = resultSet.getString("location_id");
			
			connect.prepareStatement("INSERT INTO item (item_id, description, owner_id, user_id, track_id, parent_id, item_type, status, init_loc_id, cur_loc_id, pm_date, pm_interval, num_pm_measures, pm_due_date, def_checkout_time, total_time_checked_out, def_usage_time, total_time_used, pm_cost, total_pm_cost) "
			+ "VALUES ('" + itemName + "', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'track', 'N/A', 'Gauge', 'Ready', '" + location_id + "', '" + location_id + "', '2020-01-13 00:00:00', '10', '0', '2015-02-11 00:00:00', '10', '0', '10', '0','10', '0')").executeUpdate();
			
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
	
	public void createSeleniumFactoryItem(String itemName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			connect.prepareStatement("INSERT INTO user (first_name, last_name, email_addr, contact, company_name, department, password, expired, locked, enabled, password_expired) "
					+ "VALUES ('Selenium Test User', 'Selenium Test User', 'stu@abc.com', '321-654-9871', 'Test Company', 'Test', '$2a$10$D8eImRhdH/1H4uL80N2SouLpg6X3d5nsQ8rRcah8/wO.XfzwyRKBq', 0, 0, 1, 0)").executeUpdate();
			
			String email = "stu@abc.com";
			resultSet = connect.prepareStatement("SELECT user_id FROM user where email_addr = '" + email + "'").executeQuery();
			resultSet.next();
			
			int user_id = resultSet.getInt("user_id");
			/*
			System.out.println(user_id);
			connect.prepareStatement("INSERT INTO user_role (user_id, role_id) "
					+ "VALUES (" + user_id + ", 1").executeUpdate();
			*/
			
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Store', 'Location Selenium Test Store', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Store', 'N/A', 'Store', 'Active')").executeUpdate();
			
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Factory', 'Location Selenium Test Factory', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Factory', 'N/A', 'Factory', 'Active')").executeUpdate();
			
			
			resultSet = connect.prepareStatement("SELECT location_id FROM location where location_name = 'Location Selenium Test Factory'").executeQuery();
			resultSet.next();
			
			String location_id = resultSet.getString("location_id");
			
			connect.prepareStatement("INSERT INTO item (item_id, description, owner_id, user_id, track_id, parent_id, item_type, status, init_loc_id, cur_loc_id, pm_date, pm_interval, num_pm_measures, pm_due_date, def_checkout_time, total_time_checked_out, def_usage_time, total_time_used, pm_cost, total_pm_cost) "
			+ "VALUES ('" + itemName + "', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'track', 'N/A', 'Gauge', 'Checked Out', '" + location_id + "', '" + location_id + "', '2020-01-13 00:00:00', '10', '0', '2015-02-11 00:00:00', '10', '0', '10', '0','10', '0')").executeUpdate();
			
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
	
	public void createSeleniumInUseItem(String itemName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connect = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
			
			connect.prepareStatement("INSERT INTO user (first_name, last_name, email_addr, contact, company_name, department, password, expired, locked, enabled, password_expired) "
					+ "VALUES ('Selenium Test User', 'Selenium Test User', 'stu@abc.com', '321-654-9871', 'Test Company', 'Test', '$2a$10$D8eImRhdH/1H4uL80N2SouLpg6X3d5nsQ8rRcah8/wO.XfzwyRKBq', 0, 0, 1, 0)").executeUpdate();
			
			String email = "stu@abc.com";
			resultSet = connect.prepareStatement("SELECT user_id FROM user where email_addr = '" + email + "'").executeQuery();
			resultSet.next();
			
			int user_id = resultSet.getInt("user_id");
			/*
			System.out.println(user_id);
			connect.prepareStatement("INSERT INTO user_role (user_id, role_id) "
					+ "VALUES (" + user_id + ", 1").executeUpdate();
			*/
			
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Store', 'Location Selenium Test Store', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Store', 'N/A', 'Store', 'Active')").executeUpdate();
			
			connect.prepareStatement("INSERT INTO location (location_id, location_name, description, owner_id, user_id, track_id, parent_id, location_type, status) "
					+ "VALUES ('Location Selenium Test Factory', 'Location Selenium Test Factory', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'Main Selenium Factory', 'N/A', 'Factory', 'Active')").executeUpdate();
			
			
			resultSet = connect.prepareStatement("SELECT location_id FROM location where location_name = 'Location Selenium Test Factory'").executeQuery();
			resultSet.next();
			
			String location_id = resultSet.getString("location_id");
			
			connect.prepareStatement("INSERT INTO item (item_id, description, owner_id, user_id, track_id, parent_id, item_type, status, init_loc_id, cur_loc_id, pm_date, pm_interval, num_pm_measures, pm_due_date, def_checkout_time, total_time_checked_out, def_usage_time, total_time_used, pm_cost, total_pm_cost) "
			+ "VALUES ('" + itemName + "', 'Selenium Test Description', '" + user_id + "', '" + user_id + "', 'track', 'N/A', 'Gauge', 'In Use', '" + location_id + "', '" + location_id + "', '2020-01-13 00:00:00', '10', '0', '2015-02-11 00:00:00', '10', '0', '10', '0','10', '0')").executeUpdate();
			
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