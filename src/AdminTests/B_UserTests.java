package AdminTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class B_UserTests
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
	
	//	Selenium User 1
	@Test
	public void addUser_1() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
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
		
		selenium.sendKeysById("firstName", "Selenium First Name 1");
		
		selenium.sendKeysById("lastName", "Selenium Last Name 1");
		
		selenium.sendKeysById("form-field-email", "selenium.test1@abc.com");
		
		selenium.sendKeysById("form-field-phone", "(123) 456-7890");
		
		selenium.sendKeysById("company", "Selenium Test Company 1");
		
		selenium.sendKeysById("department", "Selenium Test Department 1");
		
		selenium.sendKeysById("password", "password");
		
		selenium.selectVisibleTextById("form-field-select-2", "admin");
		
		selenium.clickElementById("createUserButton");
		
		selenium.waitUntilId("userCreateAlert");
		
		boolean successMessage = selenium.findElementById("userCreateAlert").isDisplayed();
		assertTrue("User 1 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "selenium.test1@abc.com");
		
		boolean userFound = selenium.findTextInTableById("item-table", "selenium.test1@abc.com");
		assertTrue("User 1 was not found in data table", userFound);
		
		mySQL.deleteSeleniumUser("selenium.test1@abc.com");
	}
	
	//	Selenium User 2
	@Test
	public void addUser_2() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
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
		
		selenium.sendKeysById("firstName", "Selenium First Name 2 !@#$%^&*()");
		
		selenium.sendKeysById("lastName", "Selenium Last Name 2 !@#$%^&*()");
		
		selenium.sendKeysById("form-field-email", "selenium.test2!@#$%^&*()@abc.com");
		
		selenium.sendKeysById("form-field-phone", "(123) 456-7890");
		
		selenium.sendKeysById("company", "Selenium Test Company");  // Throws Exception with !@#$%^&*()
		
		selenium.sendKeysById("department", "Selenium Test Department !@#$%^&*()");
		
		selenium.sendKeysById("password", "password");
		
		selenium.selectVisibleTextById("form-field-select-2", "admin");
		
		selenium.clickElementById("createUserButton");
		
		selenium.waitUntilId("userCreateAlert");
		
		boolean successMessage = selenium.findElementById("userCreateAlert").isDisplayed();
		assertTrue("User 2 create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "selenium.test2!@#$%^&*()@abc.com");
		
		boolean userFound = selenium.findTextInTableById("item-table", "selenium.test2!@#$%^&*()@abc.com");
		assertTrue("User 2 was not found in data table", userFound);
		
		mySQL.deleteSeleniumUser("selenium.test2!@#$%^&*()@abc.com");
	}
	
	//	Selenium Test User 3
	@Test
	public void addUser_3() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
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
		
		selenium.sendKeysById("firstName", "Selenium First Name 3");
		
		selenium.sendKeysById("lastName", "Selenium Last Name 3");
		
		selenium.sendKeysById("form-field-email", "selenium.test3@abc.com");
		
		selenium.sendKeysById("form-field-phone", "(123) 456-7890");
		
		selenium.sendKeysById("company", "Selenium Test Company");
		
		selenium.sendKeysById("department", "Selenium Test Department");
		
		selenium.sendKeysById("password", "password");
		
		selenium.clickElementById("createUserButton");
			
		boolean messageDisplayed = selenium.findElementById("userError").isDisplayed();
		String message = selenium.findElementById("userError").getText();
			
		assertTrue("User was created without a Role", messageDisplayed);
		assertTrue("Wrong Role Error Message", message.contentEquals("Please select at least one role for user."));
		
		selenium.selectVisibleTextById("form-field-select-2", "admin");
		selenium.clearElementById("firstName");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without First Name", messageDisplayed);
		assertTrue("Wrong First Name Error Message", message.contentEquals("Check First Name field and resubmit!"));
		
		//	Clears last name and checks
		selenium.sendKeysById("firstName", "Selenium First Name 3");
		selenium.clearElementById("lastName");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Last Name", messageDisplayed);
		assertTrue("Wrong Last Name Error Message", message.contentEquals("Check Last Name field and resubmit!"));

		//	Clears email and checks
		selenium.sendKeysById("lastName", "Selenium First Name 3");
		selenium.clearElementById("form-field-email");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Email", messageDisplayed);
		assertTrue("Wrong Email Error Message", message.contentEquals("Not a valid e-mail address"));
		
		//	Clears phone and checks
		selenium.sendKeysById("form-field-email", "selenium.test3@abc.com");
		selenium.clearElementById("form-field-phone");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Phone", messageDisplayed);
		assertTrue("Wrong Phone Error Message", message.contentEquals("Not a valid phone number try again!"));
		
		//	Clears company and checks
		selenium.sendKeysById("form-field-phone", "(123) 456-7890");
		selenium.clearElementById("company");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Company", messageDisplayed);
		assertTrue("Wrong Company Error Message", message.contentEquals("Check Company field and resubmit!"));
		
		//	Clears department and checks
		selenium.sendKeysById("company", "Selenium Test Company");
		selenium.clearElementById("department");
		selenium.clickElementById("createUserButton");
		
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Company", messageDisplayed);
		assertTrue("Wrong Department Error Message", message.contentEquals("Check Department field and resubmit!"));
		
		//	Clears password and checks
		selenium.sendKeysById("department", "Selenium Test Department");
		selenium.clearElementById("password");
		selenium.clickElementById("createUserButton");
			
		messageDisplayed = selenium.findElementById("userError").isDisplayed();
		message = selenium.findElementById("userError").getText();
		
		assertTrue("User was created without Password", messageDisplayed);
		assertTrue("Wrong Password Error Message", message.contentEquals("Check Password field and resubmit!"));
		
		selenium.sendKeysById("password", "password");
		
		selenium.clickElementById("createUserButton");
		
		selenium.waitUntilId("userCreateAlert");
		
		boolean successMessage = selenium.findElementById("userCreateAlert").isDisplayed();
		assertTrue("User create message not shown!", successMessage);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "selenium.test3@abc.com");
		
		boolean userFound = selenium.findTextInTableById("item-table", "selenium.test3@abc.com");
		assertTrue("User was not found in data table", userFound);
		
		mySQL.deleteSeleniumUser("selenium.test3@abc.com");
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
	*/
	/*
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
	/*
	@Test
	public void cleanUpSeleniumUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		mySQL.deleteSeleniumUser("selenium.test1@abc.com");
		mySQL.deleteSeleniumUser("selenium.test2!@#$%^&*()@abc.com");
		mySQL.deleteSeleniumUser("selenium.test3@abc.com");
	}
	*/
}
