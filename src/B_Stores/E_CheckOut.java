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

public class E_CheckOut
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{
		mySQL.createSeleniumStoreItem("Selenium Check Out Test Item");
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumItem("Selenium Check Out Test Item");
	}
	
	@Test
	public void checkOut() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathStoresLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathStoresLeftNav);
		
		selenium.waitUntilId(Constants.idGoToCheckOut);
		
		selenium.clickElementById(Constants.idGoToCheckOut);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Check Out Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Check Out Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCheckOutButton);
		
		selenium.waitUntilId("checkOutModal");
		
		selenium.selectVisibleTextById("form-field-select-2", "Location Selenium Test Factory");
		
		selenium.clickElementById("saveEditLocation");
		
		selenium.waitUntilId("itemCheckedOutAlert");
		
		boolean successMessage = selenium.findElementById("itemCheckedOutAlert").isDisplayed();
		assertTrue("Item was not checked out!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathModalCloseButton);
		
		selenium.clearElementByxPath(Constants.xPathDataTableSearch);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Check Out Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "Selenium Check Out Test Item");
		assertFalse("Item was found in table! BAD!", itemFound);
	}
}
