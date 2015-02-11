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
		mySQL.deleteSeleniumUser("selenium.test1@abc.com");
		mySQL.deleteSeleniumUser("selenium.test3@abc.com");
	}
}
