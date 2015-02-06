package utility;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFunctions
{
	WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	List<WebElement> elements;
	Select clickThis;
	
	public void setUp() throws Exception
	{	
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver(chromeCapabilities);
		
		driver.manage().window().maximize();
		
		driver.get("http://gauges.elasticbeanstalk.com");
	}
	
	public void closeBrowser() throws Exception
	{
		driver.quit();
	}
	
	public void setUpWait()
	{
		wait = new WebDriverWait(driver, 10);
	}
	
	public void adminLogin()
	{
		wait = new WebDriverWait(driver, 10);
		
		sendKeysById("username", "john.doe@abc.com");
		
		sendKeysById("password", "password");
		
		clickElementById("login-button");
		
		waitUntilTitle("idTracks - Gauges");
		
		String bodyText = findElementById("main-content").getText();
		assertTrue("Unsuccessful login!", bodyText.contains("Welcome to idTracks - Gauges (v0.1) , The manufacturing management solution for gauges, and other devices."));
	}
	
	public void waitUntilId(String id)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void waitUntilxPath(String xPath)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	public void waitUntilTitle(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
	}

	public WebElement findElementById(String id)
	{
		return driver.findElement(By.id(id));
	}
	
	public WebElement findElementByxPath(String xPath)
	{
		return driver.findElement(By.xpath(xPath));
	}
	
	public void clickElementById(String id)
	{
		driver.findElement(By.id(id)).click();
	}

	public void clickElementByxPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).click();
	}
	
	public void sendKeysById(String id, String textSent)
	{
		driver.findElement(By.id(id)).sendKeys(textSent);
	}
	
	public void sendKeysByxPath(String xPath, String textSent)
	{
		driver.findElement(By.xpath(xPath)).sendKeys(textSent);
	}
	
	public void clearElementById(String id)
	{
		driver.findElement(By.id(id)).clear();
	}
	
	public void clearElementByxPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).clear();
	}
	
	public void selectVisibleTextById(String id, String textToSelect)
	{
		element = findElementById(id);
		clickThis = new Select(element);
		clickThis.selectByVisibleText(textToSelect);
	}
}
