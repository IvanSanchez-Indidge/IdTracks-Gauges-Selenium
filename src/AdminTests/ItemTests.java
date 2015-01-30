package AdminTests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;

public class ItemTests
{
	WebDriver driver;
	
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
		login();
		
		driver.findElement(By.id("goToFactory")).click();
		
		//waitForPageLoad(driver);
		
		//driver.findElement(By.xpath(Constants.xPathItemLeftNav)).click();
		
		//waitForPageLoad(driver);
		
		//driver.findElement(By.id("goToAddItem")).click();
		
		//waitForPageLoad(driver);
	}
	
	private void login()
	{
		driver.findElement(By.id("username")).sendKeys("john.doe@abc.com");
		
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.id("login-button")).click();

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

	     Wait<WebDriver> wait = new WebDriverWait(driver, 100000);
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
