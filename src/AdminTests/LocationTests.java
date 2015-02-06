package AdminTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;

public class LocationTests
{
	WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	List<WebElement> elements;
	Select clickThis;
	
	@Before
	public void setUp() throws Exception
	{	
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver(chromeCapabilities);
		
		driver.manage().window().maximize();
		
		driver.get("http://gauges.elasticbeanstalk.com");
	}

	@After
	public void closeBrowser() throws Exception
	{
		driver.quit();
	}

	@Test
	public void addLocation() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathLocationLeftNav);
		
		clickElementByxPath(Constants.xPathLocationLeftNav);
		
		waitUntilId(Constants.idGoToAddLocation);
		
		clickElementById(Constants.idGoToAddLocation);
		
		waitUntilId("locationName");
		
		sendKeysById("locationName", "Selenium Test Location");
		
		sendKeysById("description", "Selenium Test Description");
		
		element = findElementById("ownerEmail");
		clickThis = new Select(element);
		clickThis.selectByVisibleText("John Doe (john.doe@abc.com)");
		
		sendKeysById("trackName", "Test Track Name");
		
		clickElementByxPath(Constants.xPathAddLocationPageFactoryRadioButton);
		
		clickElementById("createLocationButton");
		
		waitUntilId("locationCreateAlert");
		
		String successMessage = findElementById("locationCreateAlert").getText();
		assertTrue("Location not created successfully!", successMessage.contains("Success! Location has been added."));
	}
	
	/*
	@Test
	public void editLocation()
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathItemLeftNav);
		clickElementByxPath(Constants.xPathItemLeftNav);
		
		waitUntilId(Constants.idGoToAllLocations);
		clickElementById(Constants.idGoToAllLocations);
		
		waitUntilId("item-table");
		
		//TODO: Code that selects edit button
		
		waitUntilxPath(Constants.xPathLocationManagementPageTitle);
		
		clickElementByxPath(Constants.xPathLocationManagementPageEditLocationButton);
		
		waitUntilId("basicModal");
		
		clearElementById("description");
		sendKeysById("description", "Changed Description");
		
		clickElementById("saveEditLocation");
		
		waitUntilId("editLocationAlert");
		
		//TODO: Assert
	}
	
	@Test
	public void deactivateLocation()
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathItemLeftNav);
		clickElementByxPath(Constants.xPathItemLeftNav);
		
		waitUntilId(Constants.idGoToAllLocations);
		clickElementById(Constants.idGoToAllLocations);
		
		waitUntilId("item-table");
		
		// TODO: Code that selects deactivate button
		
		waitUntilId("locationDeactivatedAlert");
		
		String successMessage = findElementById("locationDeactivatedAlert").getText();
		assertTrue("Location not deactivated successfully!", successMessage.contains("Success! Location has been deactivated."));
	}
	*/
	
	private void login()
	{	
		sendKeysById("username", "john.doe@abc.com");
		
		sendKeysById("password", "password");
		
		clickElementById("login-button");	
	}
	
	private void waitUntilxPath(String xPath)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	private void waitUntilId(String id)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	private WebElement findElementById(String id)
	{
		return driver.findElement(By.id(id));
	}
	
	private void clickElementByxPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).click();
	}
	
	private void clickElementById(String id)
	{
		driver.findElement(By.id(id)).click();
	}
	
	private void sendKeysById(String id, String textSent)
	{
		driver.findElement(By.id(id)).sendKeys(textSent);
	}
	
	private void clearElementById(String id)
	{
		driver.findElement(By.id(id)).clear();
	}
}
