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

public class ItemTests
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
	public void addItem() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathItemLeftNav);
		
		clickElementByxPath(Constants.xPathItemLeftNav);
		
		waitUntilId(Constants.idGoToAddItem);
		
		clickElementById(Constants.idGoToAddItem);
		
		waitUntilId("itemName");
		
		sendKeysById("itemName", "Selenium Test Item 3");
		
		sendKeysById("description", "Selenium Test Description");
		
		element = findElementById("ownerEmail");
		clickThis = new Select(element);
		clickThis.selectByVisibleText("John Doe (john.doe@abc.com)");
		
		sendKeysById("trackName", "Selenium Test Track Name");
		
		clickElementByxPath(Constants.xPathAddItemPageGaugeRadioButton);
		
		sendKeysById("datePM", "01/01/2020");
		
		element = findElementById("initialLocationName");
		clickThis = new Select(element);
		clickThis.selectByVisibleText("Factory1");
		
		clickElementById("lengthPM");
		clearElementById("lengthPM");
		sendKeysById("lengthPM", "10");
		
		clearElementById("timeDefaultCheckout");
		sendKeysById("timeDefaultCheckout", "10");
		
		clearElementById("timeDefaultUsage");
		sendKeysById("timeDefaultUsage", "10");
		
		clearElementById("costPM");
		sendKeysById("costPM", "10");
		
		clickElementById("createItemButton");
		
		waitUntilId("itemCreateAlert");
		
		boolean successMessage = findElementById("itemCreateAlert").isDisplayed();
		assertTrue("Item not created successfully!", successMessage);
	}
	
	/*
	@Test
	public void editItem()
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathItemLeftNav);
		clickElementByxPath(Constants.xPathItemLeftNav);
		
		waitUntilId(Constants.idGoToAllItems);
		clickElementById(Constants.idGoToAllItems);
		
		waitUntilId("item-table");
		
		//TODO: Code that selects edit button
		
		waitUntilxPath(Constants.xPathItemManagementPageTitle);
		
		clickElementByxPath(Constants.xPathItemManagementPageEditItemButton);
		
		waitUntilId("basicModal");
		
		clearElementById("trackName");
		sendKeysById("trackName", "Changed Track Name");
		
		clickElementById("saveEditItem");
		
		waitUntilId("editItemAlert");
		
		//TODO: Assert
	}
	
	@Test
	public void deactivateItem()
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath(Constants.xPathItemLeftNav);
		clickElementByxPath(Constants.xPathItemLeftNav);
		
		waitUntilId(Constants.idGoToAllItems);
		clickElementById(Constants.idGoToAllItems);
		
		waitUntilId("item-table");
		
		// TODO: Code that selects deactivate button
		
		waitUntilId("itemDeactivatedAlert");
		
		String successMessage = findElementById("itemDeactivatedAlert").getText();
		assertTrue("Item not deactivated successfully!", successMessage.contains("Success! Item has been deactivated."));
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
