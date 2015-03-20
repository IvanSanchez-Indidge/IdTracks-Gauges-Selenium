package E_Reports;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class H_RecallReport
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{
//		mySQL.deleteSeleniumUser("stu@abc.com");
//		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
//		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
//		mySQL.deleteSeleniumPM("Selenium Calibrated Test Item");
//		mySQL.deleteSeleniumItem("Selenium Calibrated Test Item");
		
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumPM("Selenium Calibrated Test Item");
		mySQL.deleteSeleniumItem("Selenium Calibrated Test Item");
		
	}
	
	@Test
	public void recallReport() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.clickElementByxPath(Constants.xPathReportsLeftNav);
		
		selenium.waitUntilId(Constants.idGoToCreateRecallReport);
		
		selenium.clickElementById(Constants.idGoToCreateRecallReport);
		
		selenium.waitUntilId(Constants.idFromDate);
		
		selenium.sendKeysById(Constants.idFromDate, "01/01/2010");
		
		selenium.sendKeysById(Constants.idToDate, "01/02/2010");
		
		selenium.clickElementById(Constants.idCreateReportButton);
		
		selenium.waitUntilId("item-table");
		
		mySQL.createSeleniumCalibratedItem("Selenium Calibrated Test Item");
		
		selenium.clickElementById(Constants.idGoToLocatorReport);
		
		selenium.waitUntilId("item-table");
		
		selenium.clickElementById(Constants.idGoToCreateRecallReport);
		
		selenium.waitUntilId(Constants.idFromDate);
		
		selenium.sendKeysById(Constants.idFromDate, "01/01/2010");
		
		selenium.sendKeysById(Constants.idToDate, "01/02/2010");
		
		selenium.clickElementById(Constants.idCreateReportButton);
		
		selenium.waitUntilId("item-table");
		
		int numRowsAfter = selenium.findNumRowsInTableById("item-table");
		
		assertTrue("Item was not displayed on the page!", numRowsAfter == 1);
	}
}
