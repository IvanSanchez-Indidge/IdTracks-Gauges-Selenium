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
		selenium.setUp();
	}

	@After
	public void closeBrowser() throws Exception
	{
		selenium.closeBrowser();
		
		mySQL.deleteSeleniumUser("stu@abc.com");
		mySQL.deleteSeleniumLocation("Location Selenium Test Store");
		mySQL.deleteSeleniumLocation("Location Selenium Test Factory");
	}
	
	@Test
	public void calibrate_1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		mySQL.createSeleniumStoreItem("Selenium Calibration Test Item");
		
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilId(Constants.idGoToCalibrate);
		
		selenium.clickElementById(Constants.idGoToCalibrate);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("startAlert");
		
		boolean successMessage = selenium.findElementById("startAlert").isDisplayed();
		assertTrue("Item start use modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartedSuccessModalClose);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Start Use Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "In Calibration");
		assertTrue("Item has not properly started calibration!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("stopCalibration");
		
		boolean calibrationModalDisplayed = selenium.findElementById("stopCalibration").isDisplayed();
		assertTrue("Item calibration screen was not displayed!", calibrationModalDisplayed);
		
		selenium.sendKeysById("condition", "Great");
		//selenium.sendKeysById("cost", "10"); Skipped for general best case
		selenium.clickElementByxPath(Constants.xPathCalibrationApprovalPassButton);
		selenium.clickElementByxPath(Constants.xPathCalibrationStandardLengthButton);
		selenium.sendKeysById("stdUsed", "10");
		selenium.sendKeysById("standard", "10");
		selenium.sendKeysById("tolerance", "10");
		selenium.sendKeysById("measured", "10");
		selenium.sendKeysById("temperature", "54");
		selenium.sendKeysById("pressure", "10");
		selenium.sendKeysById("humidity", "10");
		selenium.sendKeysById("comments", "This is a selenium test comment");
		
		selenium.clickElementById("saveEditItem");
		
		selenium.waitUntilId("calibratedAlert");
		
		successMessage = selenium.findElementById("calibratedAlert").isDisplayed();
		assertTrue("Item calibrated alert modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationModalSuccessCloseButton);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item");
		assertTrue("Item was not found in table after calibration!", itemFound);
		
		itemFound = selenium.findTextInTableById("item-table", "Ready");
		assertTrue("Item has not properly started calibration!", itemFound);
		
		mySQL.deleteSeleniumPM("Selenium Calibration Test Item");
		mySQL.deleteSeleniumItem("Selenium Calibration Test Item");
	}
	/*
	@Test
	public void calibrate_2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		mySQL.createSeleniumStoreItem("Selenium Calibration Test Item 2.!@#$%^&*(");
		
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilId(Constants.idGoToCalibrate);
		
		selenium.clickElementById(Constants.idGoToCalibrate);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item 2.!@#$%^&*(");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item 2.!@#$%^&*(");													
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("startAlert");
		
		boolean successMessage = selenium.findElementById("startAlert").isDisplayed();
		assertTrue("Item start use modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartedSuccessModalClose);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item 2.!@#$%^&*(");
		
		itemFound = selenium.findTextInTableById("item-table", "In Calibration");
		assertTrue("Item has not properly started calibration!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("stopCalibration");
		
		boolean calibrationModalDisplayed = selenium.findElementById("stopCalibration").isDisplayed();
		assertTrue("Item calibration screen was not displayed!", calibrationModalDisplayed);
		
		selenium.sendKeysById("condition", "Great.!@#$%^&*()''");
		selenium.clearElementById("cost");
		selenium.sendKeysById("cost", "10.!@#$%^&*()''");
		selenium.clickElementByxPath(Constants.xPathCalibrationApprovalPassButton);
		selenium.clickElementByxPath(Constants.xPathCalibrationStandardLengthButton);
		selenium.sendKeysById("stdUsed", "110.!@#$%^&*()''");
		selenium.sendKeysById("standard", "10.!@#$%^&*()''");
		selenium.sendKeysById("tolerance", "10.!@#$%^&*()''");
		selenium.sendKeysById("measured", "10.!@#$%^&*()''");
		selenium.sendKeysById("temperature", "54.!@#$%^&*()''");
		selenium.sendKeysById("pressure", "10.!@#$%^&*()''");
		selenium.sendKeysById("humidity", "10.!@#$%^&*()''");
		selenium.sendKeysById("comments", "This is a selenium test comment 2.!@#$%^&*()''");
		
		selenium.clickElementById("saveEditItem");
		
		selenium.waitUntilId("calibratedAlert");
		
		selenium.clickElementByxPath(Constants.xPathCalibrationModalSuccessCloseButton);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item 2.!@#$%^&*(");
		
		itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item 2.!@#$%^&*(");
		assertTrue("Item was not found in table after calibration!", itemFound);
		
		itemFound = selenium.findTextInTableById("item-table", "Ready");
		assertTrue("Item has not properly started calibration!", itemFound);
		
		mySQL.deleteSeleniumPM("Selenium Calibration Test Item 2.!@#$%^&*(");
		mySQL.deleteSeleniumItem("Selenium Calibration Test Item 2.!@#$%^&*(");
	}
	*/
	
	/*
	@Test
	public void calibrate_3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		mySQL.createSeleniumStoreItem("Selenium Calibration Test Item");
		
		selenium.setUpWait();
		
		selenium.adminLogin();
		
		selenium.waitUntilId(Constants.idGoToCalibrate);
		
		selenium.clickElementById(Constants.idGoToCalibrate);
		
		selenium.waitUntilId("item-table");
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item");
		
		boolean itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item");
		assertTrue("Item was not found in table!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("startAlert");
		
		boolean successMessage = selenium.findElementById("startAlert").isDisplayed();
		assertTrue("Item start use modal was not displayed!", successMessage);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartedSuccessModalClose);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Start Use Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "In Calibration");
		assertTrue("Item has not properly started calibration!", itemFound);
		
		selenium.clickElementByxPath(Constants.xPathCalibrationStartStopButton);
		
		selenium.waitUntilId("stopCalibration");
		
		boolean calibrationModalDisplayed = selenium.findElementById("stopCalibration").isDisplayed();
		assertTrue("Item calibration screen was not displayed!", calibrationModalDisplayed);
		
		selenium.sendKeysById("condition", "Great");
		//selenium.sendKeysById("cost", "10"); Skipped for general best case
		//selenium.clickElementByxPath(Constants.xPathCalibrationApprovalPassButton);
		//selenium.clickElementByxPath(Constants.xPathCalibrationStandardLengthButton);
		selenium.sendKeysById("stdUsed", "10");
		selenium.sendKeysById("standard", "10");
		selenium.sendKeysById("tolerance", "10");
		selenium.sendKeysById("measured", "10");
		selenium.sendKeysById("temperature", "54");
		selenium.sendKeysById("pressure", "10");
		selenium.sendKeysById("humidity", "10");
		selenium.sendKeysById("comments", "This is a selenium test comment");
		
		selenium.clickElementById("saveEditItem");
		
		selenium.clickElementByxPath(Constants.xPathCalibrationModalSuccessCloseButton);
		
		selenium.sendKeysByxPath(Constants.xPathDataTableSearch, "Selenium Calibration Test Item");
		
		itemFound = selenium.findTextInTableById("item-table", "Selenium Calibration Test Item");
		assertTrue("Item was not found in table after calibration!", itemFound);
		
		itemFound = selenium.findTextInTableById("item-table", "Ready");
		assertTrue("Item has not properly started calibration!", itemFound);
	}
	*/
}
