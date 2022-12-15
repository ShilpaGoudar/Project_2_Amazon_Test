package baseClasses;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	
	WebDriver driver;
	public static Properties PageProperties;
	
	public GenericMethods(WebDriver driver)
	{
		this.driver=driver;
	}

	public static void explicitWait(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public static void selectOptionFromDropdown(WebElement element, String value)
	{
		Select dropdown = new Select(element);
		List<WebElement> allOptions = dropdown.getOptions();
		
		for(WebElement option:allOptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}

}
