package A_AdminTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class D_ItemTests
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
	public void addItem_1() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
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
		
		selenium.sendKeysById("itemName", "Selenium Test Item 1");
		
		selenium.sendKeysById("description", "Selenium Test Description 1");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Selenium Test Track Name 1");
		
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
		assertTrue("Item 1 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Test Item 1");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Test Item 1");
		assertTrue("Item 1 was not found in data table", itemFound);
		
		mySQL.deleteSeleniumItem("Selenium Test Item 1");
	}
	
	@Test
	public void addItem_2() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		mySQL.deleteSeleniumItem("Selenium Test Item 2 !@#$%^&*()");
		
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathItemLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathItemLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddItem);
		
		selenium.clickElementById(Constants.idGoToAddItem);
		
		selenium.waitUntilId("itemName");
		
		selenium.sendKeysById("itemName", "Selenium Test Item 2 !@#$%^&*()");
		
		selenium.sendKeysById("description", "Selenium Test Description 2 !@#$%^&*()");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Selenium Test Track Name 2");
		
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
		assertTrue("Item 2 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Test Item 2 !@#$%^&*()");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Test Item 2 !@#$%^&*()");
		assertTrue("Item 2 was not found in data table", itemFound);
		
		mySQL.deleteSeleniumItem("Selenium Test Item 2 !@#$%^&*()");
	}
	/*
	@Test
	public void addItem_3() throws InterruptedException
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
		
		selenium.sendKeysById("itemName", "Selenium Test Item 2 !@#$%^&*()");
		
		selenium.sendKeysById("description", "Selenium Test Description 2 !@#$%^&*()");
		
		selenium.selectVisibleTextById("ownerEmail", "John Doe (john.doe@abc.com)");
		
		selenium.sendKeysById("trackName", "Selenium Test Track Name 2 !@#$%^&*()");
		
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
		
		boolean messageDisplayed = selenium.findElementById("itemError").isDisplayed();
		String message = selenium.findElementById("itemError").getText();
			
		assertTrue("Item was created without a type!", messageDisplayed);
		assertTrue("Wrong Type Error Message", message.contentEquals("Please select a type and resubmit!"));
		
		selenium.clickElementByxPath(Constants.xPathAddItemPageGaugeRadioButton);
		selenium.clearElementById("locationName");
		
		selenium.clickElementById("createLocationButton");
		
		messageDisplayed = selenium.findElementById("itemError").isDisplayed();
		message = selenium.findElementById("itemError").getText();
			
		assertTrue("Item was created without a type!", messageDisplayed);
		assertTrue("Wrong Type Error Message", message.contentEquals("Check Item name field and resubmit!"));
	}
	*/
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
	/*
	@Test
	public void cleanUpSeleniumItems() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		mySQL.deleteSeleniumItem("Selenium Test Item 1");
		mySQL.deleteSeleniumItem("Selenium Test Item 2 !@#$%^&*()");
	}
	*/
}
