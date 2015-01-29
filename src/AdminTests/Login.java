package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login
{
	WebDriver driver;
	WebElement element;
	
	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://gauges.elasticbeanstalk.com");
	}

	@Test
	public void login()
	{
		element = driver.findElement(By.id("username"));
		element.sendKeys("john.doe@abc.com");
		
		element = driver.findElement(By.id("password"));
		element.sendKeys("password");
		
		element = driver.findElement(By.id("login-button"));
		element.click();
		
		String bodyText = driver.findElement(By.id("main-content")).getText();
		assertTrue("Unsuccessful login!", bodyText.contains("Welcome to idTracks - Gauges (v0.1) , The manufacturing management solution for gauges, and other devices."));
	}
	
	@After
	public void closeBrowser()
	{
		driver.quit();
	}
}