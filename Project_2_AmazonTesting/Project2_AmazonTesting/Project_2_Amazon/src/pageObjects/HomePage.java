package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseClasses.GenericMethods;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	GenericMethods GenericMethodsObject;
	
	// search for items locators
	By searchInput = By.id("twotabsearchtextbox");
	By searchClickButton = By.id("nav-search-submit-button");
	
	By priceElementsForTV = By.xpath("//span[@class='a-price-whole']");
	
	//Selecting language locators
	By countryLanguage = By.id("icp-nav-flyout");
	By selectLangList = By.id("icp-language-settings");
	By radioSelectLang = By.xpath("//*[@id=\"icp-language-settings\"]/div[2]/div/label/i");
	By langSaveChangesButton = By.xpath("//input[@class='a-button-input']");
	
	// Sign in locators
	By accountAndList = By.xpath("//*[@id=\'nav-link-accountList\']");
	By signInButton = By.id("nav-flyout-ya-signin");
	
	//Create account for new user locator
	By createAccountNewUserStartHereLink = By.xpath("//*[@id=\'nav-flyout-ya-newCust\']/a");

	// Search for item via main menu locators
	By clickMainAllMenu = By.xpath("//a[@data-csa-c-slot-id='HamburgerMenuDesktop']");
	By womenFashionSidebarItem = By.xpath("//a[@data-menu-id='11']");
	By womenClothingSidebarItem = By.xpath("//*[@id=\'hmenu-content\']/ul[11]/li[3]/a");
	
	// Search for an item and check the results shown are under the price mentioned by user
	public void searchForItems()
	{
		driver.findElement(searchInput).sendKeys("Televisions Under 50000");
		driver.findElement(searchClickButton).click();
		
		List<WebElement> TV_prices = driver.findElements(priceElementsForTV);
		for(int i=0; i<TV_prices.size(); i++)
		{
			String priceValue = TV_prices.get(i).getText();
			char ch[] = priceValue.toCharArray();
			String priceValue2="";
			for(int j=0; j<ch.length; j++)
			{
				if(ch[j]!=',')
				{
					priceValue2 = priceValue2 + ch[j];
				}
			}
			int priceValueInteger = Integer.parseInt(priceValue2);
			System.out.println(priceValueInteger);
		
			if(priceValueInteger<50000)
			{
				System.out.println("The results showing for the price below 50000");
			}
			else
			{
				System.out.println("The wrong results are shown");
			}
		}
	}
	
	// Check whether user able to select the language in which the content of page should be displayed
	public void selectCountryLanguage()
	{
		driver.findElement(countryLanguage).click();
		driver.findElement(radioSelectLang).click();
		driver.findElement(langSaveChangesButton).click();
	}
	
	// Create account for the user who does not have existing account
	public void clickCreateAccountButton()
	{
		Actions findStartHere = new Actions(driver);
		findStartHere.moveToElement(driver.findElement(accountAndList)).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Start here.")));
		driver.findElement(createAccountNewUserStartHereLink).click();
	}
	
	public void clickLoginButton()
	{
		Actions findSignIn = new Actions(driver);
		findSignIn.moveToElement(driver.findElement(accountAndList)).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
		driver.findElement(signInButton).click();
		
	}
	
	public void clickHamburgerMenu() throws Exception
	{
		driver.findElement(clickMainAllMenu).click();
	}
	
	public void clickOnWomensFashionInMenuItems() throws Exception
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('#hmenu-content').scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(womenFashionSidebarItem).click();
	}
	
	public void clickOnclothingInWomenSection() throws Exception
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('.hmenu.hmenu-visible.hmenu-translateX').scrollBy(0,100)");
		GenericMethods.explicitWait(driver, womenClothingSidebarItem);
		driver.findElement(womenClothingSidebarItem).click();
	}
	
	
	
}
