package A_AdminTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.SeleniumFunctions;

public class A_AdminLogin
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
	public void login()
	{
		selenium.setUpWait();
		
		selenium.adminLogin();
	}
}