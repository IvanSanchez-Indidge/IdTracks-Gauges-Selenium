package A_AdminTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class C_LocationTests
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
	}

	@Test
	public void addLocation_1() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathLocationLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathLocationLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddLocation);
		
		selenium.clickElementById(Constants.idGoToAddLocation);
		
		selenium.waitUntilId("locationName");
		
		selenium.sendKeysById("locationName", "Selenium Test Location 1");
		
		selenium.sendKeysById("description", "Selenium Test Description 1");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Test Track Name 1");
		
		selenium.clickElementByxPath(Constants.xPathAddLocationPageFactoryRadioButton);
		
		selenium.clickElementById("createLocationButton");
		
		selenium.waitUntilId("locationCreateAlert");
		
		boolean successMessage = selenium.findElementById("locationCreateAlert").isDisplayed();
		assertTrue("Location 1 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Test Location");
		
		boolean locationFound = selenium.findTextInTableById("item-table", "Selenium Test Location 1");
		assertTrue("Location 1 was not found in data table", locationFound);
		
		mySQL.deleteSeleniumLocation("Selenium Test Location 1");
		
		
	}
	
	@Test
	public void addLocation_2() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathLocationLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathLocationLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddLocation);
		
		selenium.clickElementById(Constants.idGoToAddLocation);
		
		selenium.waitUntilId("locationName");
		
		selenium.sendKeysById("locationName", "Selenium Test Location 2 !@#$%^&*()");
		
		selenium.sendKeysById("description", "Selenium Test Description 2 !@#$%^&*()");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Test Track Name 2 !@#$%^&*()");
		
		selenium.clickElementByxPath(Constants.xPathAddLocationPageFactoryRadioButton);
		
		selenium.clickElementById("createLocationButton");
		
		selenium.waitUntilId("locationCreateAlert");
		
		boolean successMessage = selenium.findElementById("locationCreateAlert").isDisplayed();
		assertTrue("Location 2 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Test Location 2 !@#$%^&*()");
		
		boolean locationFound = selenium.findTextInTableById("item-table", "Selenium Test Location 2 !@#$%^&*()");
		assertTrue("Location 2 was not found in data table", locationFound);
		
		mySQL.deleteSeleniumLocation("Selenium Test Location 2 !@#$%^&*()");
	}
	
	@Test
	public void addLocation_3() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathLocationLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathLocationLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddLocation);
		
		selenium.clickElementById(Constants.idGoToAddLocation);
		
		selenium.waitUntilId("locationName");
		
		selenium.sendKeysById("locationName", "Selenium Test Location 3");
		
		selenium.sendKeysById("description", "Selenium Test Description");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Test Track Name");
		
		selenium.clickElementById("createLocationButton");
		
		boolean messageDisplayed = selenium.findElementById("locationError").isDisplayed();
		String message = selenium.findElementById("locationError").getText();
			
		assertTrue("Location was created without a type!", messageDisplayed);
		assertTrue("Wrong Type Error Message", message.contentEquals("Select a type and resubmit!"));
		
		selenium.clickElementByxPath(Constants.xPathAddLocationPageFactoryRadioButton);
		selenium.clearElementById("locationName");
		
		selenium.clickElementById("createLocationButton");
		
		messageDisplayed = selenium.findElementById("locationError").isDisplayed();
		message = selenium.findElementById("locationError").getText();
		
		assertTrue("Location was created without a name!", messageDisplayed);
		assertTrue("Wrong Name Error Message", message.contentEquals("Check Location name field and resubmit!"));
		
		selenium.sendKeysById("locationName", "Selenium Test Location 3");
		selenium.clearElementById("description");
		
		selenium.clickElementById("createLocationButton");
		
		messageDisplayed = selenium.findElementById("locationError").isDisplayed();
		message = selenium.findElementById("locationError").getText();
			
		assertTrue("Location was created without a description!", messageDisplayed);
		assertTrue("Wrong Description Error Message", message.contentEquals("Check Description field and resubmit!"));
		
		selenium.sendKeysById("description", "Selenium Test Description");
		selenium.selectVisibleTextById("ownerEmail", "---SELECT OWNER---");
		
		selenium.clickElementById("createLocationButton");
		
		messageDisplayed = selenium.findElementById("locationError").isDisplayed();
		message = selenium.findElementById("locationError").getText();
			
		assertTrue("Location was created without an owner!", messageDisplayed);
		assertTrue("Wrong Owner Error Message", message.contentEquals("Check Owner email field and resubmit!"));
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		selenium.clearElementById("trackName");
		
		selenium.clickElementById("createLocationButton");
		
		messageDisplayed = selenium.findElementById("locationError").isDisplayed();
		message = selenium.findElementById("locationError").getText();
			
		assertTrue("Location was created without a track name!", messageDisplayed);
		assertTrue("Wrong Track Name Error Message", message.contentEquals("Check Track name field and resubmit!"));
		
		selenium.sendKeysById("trackName", "Test Track Name");
		
		selenium.clickElementById("createLocationButton");
		
		selenium.waitUntilId("locationCreateAlert");
		
		boolean successMessage = selenium.findElementById("locationCreateAlert").isDisplayed();
		assertTrue("Location 3 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Test Location 3");
		
		boolean locationFound = selenium.findTextInTableById("item-table", "Selenium Test Location 3");
		assertTrue("Location 3 was not found in data table", locationFound);
		
		mySQL.deleteSeleniumLocation("Selenium Test Location 3");
	}
	
	/*
	@Test
	public void editLocation()
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAllLocations);
		selenium.clickElementById(Constants.idGoToAllLocations);
		
		selenium.waitUntilId("item-table");
		
		//TODO: Code that selects edit button
		
		selenium.waitUntilxPath(Constants.xPathLocationManagementPageTitle);
		
		selenium.clickElementByxPath(Constants.xPathLocationManagementPageEditLocationButton);
		
		selenium.waitUntilId("basicModal");
		
		selenium.clearElementById("description");
		selenium.sendKeysById("description", "Changed Description");
		
		selenium.clickElementById("saveEditLocation");
		
		selenium.waitUntilId("editLocationAlert");
		
		//TODO: Assert
	}
	
	@Test
	public void deactivateLocation()
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAllLocations);
		selenium.clickElementById(Constants.idGoToAllLocations);
		
		selenium.waitUntilId("item-table");
		
		// TODO: Code that selects deactivate button
		
		selenium.waitUntilId("locationDeactivatedAlert");
		
		String successMessage = selenium.findElementById("locationDeactivatedAlert").getText();
		assertTrue("Location not deactivated successfully!", successMessage.contains("Success! Location has been deactivated."));
	}
	*/
	/*
	@Test
	public void cleanUpSeleniumLocations() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		mySQL.deleteSeleniumLocation("Selenium Test Location 1");
		mySQL.deleteSeleniumLocation("Selenium Test Location 2 !@#$%^&*()");
		mySQL.deleteSeleniumLocation("Selenium Test Location 3");
	}
	*/
}