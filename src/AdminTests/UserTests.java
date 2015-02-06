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

public class UserTests
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
	public void addUser() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		waitUntilxPath(Constants.xPathAdminLeftNav);
		
		clickElementByxPath(Constants.xPathAdminLeftNav);
		
		waitUntilxPath("/html/body[@class='no-skin']/div[@id='main-container']/div[@id='sidebar']/ul[@class='nav nav-list']/li[@class='hsub open']/ul[@class='submenu nav-show']/li[@class='hsub open']/a[@class='dropdown-toggle']");
		
		clickElementByxPath(Constants.xPathUserLeftNav);
		
		waitUntilId(Constants.idGoToAddUser);
		
		clickElementById(Constants.idGoToAddUser);
		
		waitUntilId("firstName");
		
		sendKeysById("firstName", "Selenium First Name");
		
		sendKeysById("lastName", "Selenium Last Name");
		
		sendKeysById("form-field-email", "selenium.test@abc.com");
		
		sendKeysById("form-field-phone", "(123) 456-7890");
		
		sendKeysById("company", "Selenium Test Company");
		
		sendKeysById("department", "Selenium Test Department");
		
		sendKeysById("password", "password");
		
		element = findElementById("form-field-select-2");
		clickThis = new Select(element);
		clickThis.selectByVisibleText("admin");
		
		clickElementById("createUserButton");
		
		waitUntilId("userCreateAlert");
		
		String successMessage = findElementById("userCreateAlert").getText();
		assertTrue("User not created successfully!", successMessage.contains("Success! User has been added."));
	}
	/*
	@Test
	public void editUser()
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
	public void deactivateUser()
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
