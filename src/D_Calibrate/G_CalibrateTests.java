package D_Calibrate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class G_CalibrateTests
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	MySQLAccess mySQL = new MySQLAccess();
	
	@Before
	public void setUp() throws Exception
	{
		mySQL.createSeleniumStoreItem("Selenium Calibration Test Item");
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
		mySQL.deleteSeleniumItem("Selenium Calibration Test Item");
	}
	
	@Test
	public void calibrate_1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilId(Constants.idGoToCalibrate);
		
		selenium.clickElementById(Constants.idGoToCalibrate);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathStartStopButton);
		
		selenium.waitUntilId("");
		
		boolean successMessage = selenium.findElementById("").isDisplayed();
		assertTrue("Item start use modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathStartUseModalCloseButton);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Start Use Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "In Use");
		assertTrue("Item was not properly started!", itemFound);
	}
}
