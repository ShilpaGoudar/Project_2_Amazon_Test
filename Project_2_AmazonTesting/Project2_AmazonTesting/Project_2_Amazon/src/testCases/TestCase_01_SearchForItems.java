package testCases;

import org.testng.annotations.Test;

import baseClasses.TestBaseForLaunchUrl;
import pageObjects.HomePage;

public class TestCase_01_SearchForItems extends TestBaseForLaunchUrl{
	
	HomePage HomePageObject;
	
	@Test
	public void searchForItems() throws Exception
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.searchForItems();
	}

}
