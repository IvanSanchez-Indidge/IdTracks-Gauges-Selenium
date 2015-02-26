package C_Factory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class F_StopUse
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{
		mySQL.createSeleniumFactoryItem("Selenium Stop Use Test Item");
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumItem("Selenium Stop Use Test Item");
	}
	
	@Test
	public void checkOut() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilId(Constants.idGoToFactory);
		
		selenium.clickElementById(Constants.idGoToFactory);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Stop Use Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Stop Use Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathStartStopButton);
		
		selenium.waitUntilId("stopUsageAlert");
		
		boolean successMessage = selenium.findElementById("stopUsageAlert").isDisplayed();
		assertTrue("Item stop use modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathStopUseModalCloseButton);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Stop Use Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "Checked Out");
		assertTrue("Item was not properly stopped!", itemFound);
	}
}
