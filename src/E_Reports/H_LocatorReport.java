package E_Reports;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class H_LocatorReport
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{		
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumItem("Selenium Locator Report Test Item");
	}
	
	@Test
	public void recallReport() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathReportsLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathReportsLeftNav);
		
		selenium.waitUntilId(Constants.idGoToLocatorReport);
		
		selenium.clickElementById(Constants.idGoToLocatorReport);
		
		selenium.waitUntilId("item-table");
		
		int numRowsBefore = selenium.findNumRowsInTableById("item-table");
		
		mySQL.createSeleniumStoreItem("Selenium Locator Report Test Item");
		
		selenium.clickElementById(Constants.idGoToCreateRecallReport);
		
		selenium.waitUntilId(Constants.idCreateRecallReportForm);
		
		selenium.clickElementById(Constants.idGoToLocatorReport);
		
		selenium.waitUntilId("item-table");
		
		int numRowsAfter = selenium.findNumRowsInTableById("item-table");
		
		assertTrue("Report not showing newly added item!", numRowsAfter == numRowsBefore + 1);
	}
}
