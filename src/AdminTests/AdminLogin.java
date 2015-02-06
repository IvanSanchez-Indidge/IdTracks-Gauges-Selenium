package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLogin
{
	WebDriver driver;
	WebDriverWait wait;
	
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
	public void login()
	{
		wait = new WebDriverWait(driver, 10);
		
		sendKeysById("username", "john.doe@abc.com");
		
		sendKeysById("password", "password");
		
		clickElementById("login-button");
		
		waitUntilTitle("idTracks - Gauges");
		
		String bodyText = findElementById("main-content").getText();
		assertTrue("Unsuccessful login!", bodyText.contains("Welcome to idTracks - Gauges (v0.1) , The manufacturing management solution for gauges, and other devices."));
	}
	
	private void waitUntilTitle(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
	}

	private WebElement findElementById(String id)
	{
		return driver.findElement(By.id(id));
	}
	
	private void clickElementById(String id)
	{
		driver.findElement(By.id(id)).click();
	}
	
	private void sendKeysById(String id, String textSent)
	{
		driver.findElement(By.id(id)).sendKeys(textSent);
	}
}