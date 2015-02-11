package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.SeleniumFunctions;

public class C_LocationTests
{
	SeleniumFunctions selenium = new SeleniumFunctions();
	
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
	public void addLocation() throws InterruptedException
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
		
		selenium.sendKeysById("locationName", "Selenium Test Location");
		
		selenium.sendKeysById("description", "Selenium Test Description");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Test Track Name");
		
		selenium.clickElementByxPath(Constants.xPathAddLocationPageFactoryRadioButton);
		
		selenium.clickElementById("createLocationButton");
		
		selenium.waitUntilId("locationCreateAlert");
		
		boolean successMessage = selenium.findElementById("locationCreateAlert").isDisplayed();
		assertTrue("Location not created successfully!", successMessage);
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
}
