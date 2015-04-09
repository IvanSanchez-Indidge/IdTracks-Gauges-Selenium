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
	public WebDriver driver;
	public WebDriverWait wait;
	public WebElement element;
	public List<WebElement> elements;
	public List<WebElement> tr_collection;
	public List<WebElement> td_collection;
	public Select clickThis;
	
	/* Opens the browser, maximizes the window and opens the URL */
	public void setUp() throws Exception
	{	
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver(chromeCapabilities);
		
		driver.manage().window().maximize();
		
		driver.get("http://gauges.elasticbeanstalk.com");
	}
	
	/* Closes the browser and ends all processes on it */
	public void closeBrowser() throws Exception
	{
		driver.quit();
	}
	
	/* Used for when waiting for an ID or xPath. Waits 10 seconds. If the element does not appear after 10 seconds, it exits */
	public void setUpWait()
	{
		wait = new WebDriverWait(driver, 10);
	}
	
	
	/* Admin login method */
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
	
	/* Used when you want to wait for an element to appear providing its id. Used mostly when the element doesn't appear as fast as the code is executed */
	public void waitUntilId(String id)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	/* Used when you want to wait for an element to appear providing its xPath. Used mostly when the element doesn't appear as fast as the code is executed */
	public void waitUntilxPath(String xPath)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	/* Used when you want to wait for a specific title on the page to appear. Used mostly when the element doesn't appear as fast as the code is executed */
	public void waitUntilTitle(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	/* Find an element providing its id and allows you to use the other various WebElement methods with the element */
	public WebElement findElementById(String id)
	{
		return driver.findElement(By.id(id));
	}
	
	/* Find an element providing its xPath and allows you to use the other various WebElement methods with the element */
	public WebElement findElementByxPath(String xPath)
	{
		return driver.findElement(By.xpath(xPath));
	}
	
	/* Click an element providing its id. Ex: A Button */
	public void clickElementById(String id)
	{
		driver.findElement(By.id(id)).click();
	}

	/* Click an element providing its xPath. Ex: A Button that doesn't have an id */
	public void clickElementByxPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).click();
	}
	
	/* Type into a text box providing its id */
	public void sendKeysById(String id, String textSent)
	{
		driver.findElement(By.id(id)).sendKeys(textSent);
	}
	
	/* Type into a text box providing its xPath */
	public void sendKeysByxPath(String xPath, String textSent)
	{
		driver.findElement(By.xpath(xPath)).sendKeys(textSent);
	}
	
	/* Clear the contents of an element providing its id. Ex: clear a textbox */
	public void clearElementById(String id)
	{
		driver.findElement(By.id(id)).clear();
	}
	
	/* Clear the contents of an element providing its xPath */
	public void clearElementByxPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).clear();
	}
	
	/* Select an item from a dropdown box providing its id*/
	public void selectVisibleTextById(String id, String textToSelect)
	{
		element = findElementById(id);
		clickThis = new Select(element);
		clickThis.selectByVisibleText(textToSelect);
	}
	
	public void clickRadioBoxWithIdByValue(String id, String value)
	{
		String radioButtonXPath = "//input[contains(@id, '" + id + "') and contains(@value, " + value + ")]";
		driver.findElement(By.xpath(radioButtonXPath)).click();
	}
	
	/* Find text within a table providing the tableId. You want to first search for what you're looking for, then use this. Searching an entire table not yet implemented */
	public boolean findTextInTableById(String tableId, String textYouAreLookingFor)
	{
		boolean textFound = false;
		element = driver.findElement(By.id(tableId));
		tr_collection = element.findElements(By.xpath("id('" + tableId + "')/tbody/tr"));
		
		for(WebElement trElement : tr_collection)
		{
			td_collection = trElement.findElements(By.xpath("td"));
			
			for(WebElement tdElement : td_collection)
			{
				if(textYouAreLookingFor.contentEquals(tdElement.getText()))
				{
					textFound = true;
				}
			}
		}
		
		return textFound;
	}
	
	public int findNumRowsInTableById(String tableId)
	{
		return driver.findElements(By.xpath("//table[@id='" + tableId + "']/tbody/tr")).size();
	}
}
