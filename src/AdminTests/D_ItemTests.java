package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.SeleniumFunctions;

public class D_ItemTests
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
	public void addItem() throws InterruptedException
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddItem);
		
		selenium.clickElementById(Constants.idGoToAddItem);
		
		selenium.waitUntilId("itemName");
		
		selenium.sendKeysById("itemName", "Selenium Test Item 3");
		
		selenium.sendKeysById("description", "Selenium Test Description");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Selenium Test Track Name");
		
		selenium.clickElementByxPath(Constants.xPathAddItemPageGaugeRadioButton);
		
		selenium.sendKeysById("datePM", "01/01/2020");
		
		selenium.selectVisibleTextById("initialLocationName", "Factory1");
		
		selenium.clickElementById("lengthPM");
		selenium.clearElementById("lengthPM");
		selenium.sendKeysById("lengthPM", "10");
		
		selenium.clearElementById("timeDefaultCheckout");
		selenium.sendKeysById("timeDefaultCheckout", "10");
		
		selenium.clearElementById("timeDefaultUsage");
		selenium.sendKeysById("timeDefaultUsage", "10");
		
		selenium.clearElementById("costPM");
		selenium.sendKeysById("costPM", "10");
		
		selenium.clickElementById("createItemButton");
		
		selenium.waitUntilId("itemCreateAlert");
		
		boolean successMessage = selenium.findElementById("itemCreateAlert").isDisplayed();
		assertTrue("Item not created successfully!", successMessage);
	}
	
	/*
	@Test
	public void editItem()
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAllItems);
		selenium.clickElementById(Constants.idGoToAllItems);
		
		selenium.waitUntilId("item-table");
		
		//TODO: Code that selects edit button
		
		selenium.waitUntilxPath(Constants.xPathItemManagementPageTitle);
		
		selenium.clickElementByxPath(Constants.xPathItemManagementPageEditItemButton);
		
		selenium.waitUntilId("basicModal");
		
		selenium.clearElementById("trackName");
		selenium.sendKeysById("trackName", "Changed Track Name");
		
		selenium.clickElementById("saveEditItem");
		
		selenium.waitUntilId("editItemAlert");
		
		//TODO: Assert
	}
	
	@Test
	public void deactivateItem()
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAllItems);
		selenium.clickElementById(Constants.idGoToAllItems);
		
		selenium.waitUntilId("item-table");
		
		// TODO: Code that selects deactivate button
		
		selenium.waitUntilId("itemDeactivatedAlert");
		
		String successMessage = selenium.findElementById("itemDeactivatedAlert").getText();
		assertTrue("Item not deactivated successfully!", successMessage.contains("Success! Item has been deactivated."));
	}
	*/
}
