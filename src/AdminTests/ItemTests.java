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
		//driver.quit();
	}

	@Test
	public void addItem() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		
		login();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.xPathAdminLeftNav)));
		
		driver.findElement(By.xpath(Constants.xPathAdminLeftNav)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.xPathItemLeftNav)));
		
		driver.findElement(By.xpath(Constants.xPathItemLeftNav)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToAddItem")));
		
		driver.findElement(By.id("goToAddItem")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemName")));
		
		driver.findElement(By.id("itemName")).sendKeys("Selenium Test Item");
		
		driver.findElement(By.id("description")).sendKeys("Selenium Test Description");
		
		element = driver.findElement(By.id("ownerEmail"));
		clickThis = new Select(element);
		clickThis.selectByVisibleText("John Doe (john.doe@abc.com)");
		
		driver.findElement(By.id("trackName")).sendKeys("Selenium Test Track Name");
		
		driver.findElement(By.xpath(Constants.xPathGaugeRadioButton)).click();
		
		driver.findElement(By.id("datePM")).sendKeys("01/01/2020");
		
		element = driver.findElement(By.id("initialLocationName"));
		clickThis = new Select(element);
		clickThis.selectByVisibleText("Factory1");
		
		driver.findElement(By.id("lengthPM")).click();
		driver.findElement(By.id("lengthPM")).clear();
		driver.findElement(By.id("lengthPM")).sendKeys("10");
		
		driver.findElement(By.id("timeDefaultCheckout")).clear();
		driver.findElement(By.id("timeDefaultCheckout")).sendKeys("10");
		
		driver.findElement(By.id("timeDefaultUsage")).clear();
		driver.findElement(By.id("timeDefaultUsage")).sendKeys("10");
		
		driver.findElement(By.id("costPM")).clear();
		driver.findElement(By.id("costPM")).sendKeys("10");
		
		driver.findElement(By.id("createItemButton")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToAllItems")));
		
		driver.findElement(By.id("goToAddItem")).click();
		
		//String bodyText = driver.findElement(By.id("main-content")).getText();
		//assertTrue("Failed to create item!", bodyText.contains("Success! Item has been added."));
	}
	
	private void login()
	{	
		driver.findElement(By.id("username")).sendKeys("john.doe@abc.com");
		
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.id("login-button")).click();	
	}
}
