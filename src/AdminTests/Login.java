package AdminTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login
{
	WebDriver driver;
	WebElement element;
	
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
		element = driver.findElement(By.id("username"));
		element.sendKeys("john.doe@abc.com");
		
		element = driver.findElement(By.id("password"));
		element.sendKeys("password");
		
		element = driver.findElement(By.id("login-button"));
		element.click();
		
		waitForPageLoad(driver);
		
		String bodyText = driver.findElement(By.id("main-content")).getText();
		assertTrue("Unsuccessful login!", bodyText.contains("Welcome to idTracks - Gauges (v0.1) , The manufacturing management solution for gauges, and other devices."));
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
	    		 {
	    	 		public Boolean apply(WebDriver driver)
	    	 		{
	    	 			return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	    	 		}
	    		 };

	     Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	     try
	     {
	    	 wait.until(expectation);
	     }
	     catch(Throwable error)
	     {
	    	 assertFalse("Timeout waiting for Page Load Request to complete.", true);
	     }
	}
}