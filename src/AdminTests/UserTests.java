package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.SeleniumFunctions;

public class UserTests
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
	public void addUser() throws InterruptedException
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathAdminLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathAdminLeftNav);
		
		selenium.waitUntilxPath(Constants.xPathUserLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathUserLeftNav);
		
		selenium.waitUntilId(Constants.idGoToAddUser);
		
		selenium.clickElementById(Constants.idGoToAddUser);
		
		selenium.waitUntilId("firstName");
		
		selenium.sendKeysById("firstName", "Selenium First Name");
		
		selenium.sendKeysById("lastName", "Selenium Last Name");
		
		selenium.sendKeysById("form-field-email", "selenium.test@abc.com");
		
		selenium.sendKeysById("form-field-phone", "(123) 456-7890");
		
		selenium.sendKeysById("company", "Selenium Test Company");
		
		selenium.sendKeysById("department", "Selenium Test Department");
		
		selenium.sendKeysById("password", "password");
		
		selenium.selectVisibleTextById("form-field-select-2", "admin");
		
		selenium.clickElementById("createUserButton");
		
		selenium.waitUntilId("userCreateAlert");
		
		boolean successMessage = selenium.findElementById("userCreateAlert").isDisplayed();
		assertTrue("User not created successfully!", successMessage);
	}
	/*
	@Test
	public void editUser()
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
	public void deactivateUser()
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
