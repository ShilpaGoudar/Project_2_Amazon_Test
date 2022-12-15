package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.TestBaseForLaunchUrl;
import pageObjects.HomePage;
import pageObjects.WomenClothingPage;

public class TestCase_04_AddItemToCart extends TestBaseForLaunchUrl{
	
	HomePage HomePageObject;
	WomenClothingPage WomenClothingPageObject;
	
	@Test
	public void addWomenClothingItemToCart() throws Exception
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.clickHamburgerMenu();
		HomePageObject.clickOnWomensFashionInMenuItems();
		HomePageObject.clickOnclothingInWomenSection();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Clothing for Women online : Best brands for women's clothing at best prices only on Amazon.in";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		
		WomenClothingPageObject = new WomenClothingPage(driver);
		WomenClothingPageObject.clickOnSubCardImage();
		WomenClothingPageObject.makePriceBrandColurSelection();
		WomenClothingPageObject.selectAnItemFromFilter();
		WomenClothingPageObject.addSelectedItemToCart();
	}

}
