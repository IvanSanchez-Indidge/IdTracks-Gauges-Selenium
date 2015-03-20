package E_Reports;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Constants;
import utility.MySQLAccess;
import utility.SeleniumFunctions;

public class H_TraceReport
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
	public void recallReport() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilxPath(Constants.xPathReportsLeftNav);
		
		selenium.clickElementByxPath(Constants.xPathReportsLeftNav);
		
		selenium.waitUntilId(Constants.idGoToTraceReport);
		
		selenium.clickElementById(Constants.idGoToTraceReport);	
		
		selenium.waitUntilId("form-field-select-2");
		
		selenium.selectVisibleTextById("form-field-select-2", "D-45123456");
		
		selenium.clickElementById(Constants.idCreateReportButton);
		
		selenium.waitUntilId("item-table");
		
		int numRows = selenium.findNumRowsInTableById("item-table");
		
		assertTrue("Table did not populate!", numRows >= 1);
	}
}
