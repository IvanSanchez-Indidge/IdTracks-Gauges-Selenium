package AdminTests;

import java.sql.SQLException;

import org.junit.Test;

import utility.MySQLAccess;

public class Z_CleanUpDB
{
	MySQLAccess mySQL = new MySQLAccess();
	
	@Test
	public void cleanUpDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		/*
		mySQL.deleteSeleniumUser("selenium.test1@abc.com");
		mySQL.deleteSeleniumUser("selenium.test2!@#$%^&*()@abc.com");
		mySQL.deleteSeleniumUser("selenium.test3@abc.com");
		
		mySQL.deleteSeleniumLocation("Selenium Test Location 1");
		mySQL.deleteSeleniumLocation("Selenium Test Location 2 !@#$%^&*()");
		mySQL.deleteSeleniumLocation("Selenium Test Location 3");
		
		mySQL.deleteSeleniumItem("Selenium Test Item 1");
		mySQL.deleteSeleniumItem("Selenium Test Item 2 !@#$%^&*()");*/
		
		mySQL.deleteSeleniumUser("stu@abc.com");
				mySQL.deleteSeleniumLocation("Location Selenium Test");
				mySQL.deleteSeleniumItem("Selenium Check In Test Item");
	}
}
