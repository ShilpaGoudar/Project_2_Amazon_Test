package baseClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForPages {
	
	protected static WebDriver driver;
	private WebDriverWait wait;
	
	public BaseClassForPages(WebDriver driver)
	{
		BaseClassForPages.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	protected void waitForVisibleElemnt(By locator)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}
