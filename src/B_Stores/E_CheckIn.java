package B_Stores;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class E_CheckIn
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{
		mySQL.createSeleniumFactoryItem("Selenium Check In Test Item");
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumItem("Selenium Check In Test Item");
	}
	
	@Test
	public void checkOut() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathStoresLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathStoresLeftNav);
		
		selenium.waitUntilId(Constants.idGoToCheckIn);
		
		selenium.clickElementById(Constants.idGoToCheckIn);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Check In Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Check In Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCheckInButton);
		
		selenium.waitUntilId("checkInModal");
		
		selenium.selectVisibleTextById("form-field-select-2", "Location Selenium Test Store");
		
		selenium.clickElementById("saveEditLocation");
		
		selenium.waitUntilId("itemCheckedInAlert");
		
		boolean successMessage = selenium.findElementById("itemCheckedInAlert").isDisplayed();
		assertTrue("Item was not checked in!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathCheckInModalCloseButton);
		
		selenium.clearElementByxPath(Constants.xPathDataTableSearch);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Check In Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "Selenium Check In Test Item");
		assertFalse("Item was found in table! BAD!", itemFound);
	}
}
