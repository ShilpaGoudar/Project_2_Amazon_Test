package pageObjects;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClasses.GenericMethods;

public class WomenClothingPage {
	
	WebDriver driver;
	
	GenericMethods GenericMethodsObject;
	
	By roungSubCardImage = By.xpath("//*[@id=\'sobe_d_b_1_5\']/a/div[1]/img");
	By minMaxPriceSelect = By.xpath("//*[@id=\"p_36/4595087031\"]/span/a/span");
	By clearBrandsSelected = By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[1]/span/a/span[2]");
	By selectColour = By.xpath("//*[@id=\"p_n_size_two_browse-vebin/1975318031\"]/span/a/span/div");
	By selectItemRegularKurtaDress = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[1]/div/span/a/div/img");
	By addToCartButton = By.xpath("//*[@id=\"add-to-cart-button\"]");
	By addedToCartMessage = By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	
	public WomenClothingPage(WebDriver driver) {
		this.driver=driver;
	}

	public void clickOnSubCardImage()
	{
		driver.findElement(roungSubCardImage).click();
	}
	
	public void makePriceBrandColurSelection()
	{
		driver.findElement(minMaxPriceSelect).click();
		driver.findElement(clearBrandsSelected).click();
		driver.findElement(selectColour).click();
	}
	
	public void selectAnItemFromFilter()
	{
		driver.findElement(selectItemRegularKurtaDress).click();
	}
	
	public void addSelectedItemToCart() throws Exception
	{
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		
		WebElement selectSizeDropDown = driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']"));
		GenericMethods.selectOptionFromDropdown(selectSizeDropDown, "L");
		Thread.sleep(5000);
		GenericMethods.explicitWait(driver, addToCartButton);
		driver.findElement(addToCartButton).click();
		Thread.sleep(5000);
		String MessageToAddItemToCart = driver.findElement(addedToCartMessage).getText();
		System.out.println(MessageToAddItemToCart);
	}
	
}
